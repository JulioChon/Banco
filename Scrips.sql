
delimiter $$
CREATE PROCEDURE historialTransferenciasRealizadas(in numeroReferencia int)
begin 
  Select numero_cuenta,transferencias.monto,transferencias.fecha from cuentas 
  inner join transferencias on cuentas.numero_cuenta = transferencias.codigo_emisor
  where cuentas.numero_cuenta = numeroReferencia;
end; 
$$ 

delimiter $$
CREATE PROCEDURE historialRetirosSinCuenta(in numeroReferencia int)
begin 
  Select numero_cuenta,retirossincuenta.monto,retirossincuenta.monto from cuentas 
  inner join retirossincuenta on cuentas.numero_cuenta = retirossincuenta.cuenta_retirada
  where cuentas.numero_cuenta = numeroReferencia and retirossincuenta.estado like "Cobrado";
end; 
$$ 

delimiter $$
CREATE PROCEDURE historialTransferenciasRecibidas(in numeroReferencia int)
begin 
  Select numero_cuenta,transferencias.monto,transferencias.fecha from cuentas 
  inner join transferencias on cuentas.numero_cuenta = transferencias.codigo_Receptor
  where cuentas.numero_cuenta = numeroReferencia;
end; 
$$ 

delimiter $$
Create trigger generarContrasena before insert on retirosSinCuenta
for each row begin 
set new.contraseña = LPAD(FLOOR(RAND() * 99999999), 8, '0');
end;
$$

delimiter $$ 
CREATE PROCEDURE codigoTransferencia(IN emisor INT, IN receptor INT, IN montoTransferencia DECIMAL(10, 2))
BEGIN
    DECLARE saldo_origen DECIMAL(10, 2);
    START TRANSACTION;
    SELECT monto INTO saldo_origen FROM cuentas WHERE numero_cuenta = emisor FOR UPDATE;
    IF (saldo_origen >= montoTransferencia) THEN
        UPDATE cuentas SET monto = monto - montoTransferencia WHERE numero_cuenta = emisor;
        UPDATE cuentas SET monto = monto + montoTransferencia WHERE numero_cuenta = receptor;
        INSERT INTO transferencias (monto, codigo_emisor, codigo_receptor) VALUES (montoTransferencia, emisor, receptor);
        COMMIT;
    ELSE
        ROLLBACK;
    END IF;
END
$$
