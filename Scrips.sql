
delimiter $$
CREATE PROCEDURE historialTransferenciasRealizadas(in numeroReferencia int,in numeroElementos int, in elemntosSaltar int,in fechaInicio date,in fechaFinal date )
begin 
  Select transferencias.codigo_receptor,transferencias.monto,transferencias.fecha from cuentas 
  inner join transferencias on cuentas.numero_cuenta = transferencias.codigo_emisor
  where cuentas.numero_cuenta = numeroReferencia and  transferencias.fecha between fechaInicio and  fechaFinal
  order by transferencias.fecha desc
  limit numeroElementos offset elemntosSaltar ;
end; 
$$ 

delimiter $$
CREATE PROCEDURE historialRetirosSinCuenta(in numeroReferencia int,in numeroElementos int, in elemntosSaltar int,in fechaInicio date,in fechaFinal date)
begin 
  Select retirossincuenta.monto,retirossincuenta.fecha,folio from cuentas 
  inner join retirossincuenta on cuentas.numero_cuenta = retirossincuenta.cuenta_retirada
  where cuentas.numero_cuenta = numeroReferencia and retirossincuenta.estado like "Cobrado" 
  and  retirossincuenta.fecha between fechaInicio and  fechaFinal
  order by retirossincuenta.fecha desc
  limit numeroElementos offset elemntosSaltar ;
end; 
$$ 
drop procedure historialTransferenciasRealizadas



delimiter $$
CREATE PROCEDURE historialTransferenciasRecibidas(in numeroReferencia int, in numeroElementos int,in elemntosSaltar int,in fechaInicio date,in fechaFinal date)
begin 
  Select transferencias.codigo_emisor,transferencias.monto,transferencias.fecha from cuentas 
  inner join transferencias on cuentas.numero_cuenta = transferencias.codigo_Receptor
  where cuentas.numero_cuenta = numeroReferencia and  transferencias.fecha between fechaInicio and  fechaFinal
  order by transferencias.fecha desc limit numeroElementos offset elemntosSaltar;
end; 
$$ 

delimiter $$
Create trigger generarContrasena before insert on retirosSinCuenta
for each row begin 
set new.contraseña = aes_encrypt(LPAD(FLOOR(RAND() * 99999999), 8, '0'),"hunter2");
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
        signal sqlstate '45000' set message_text = "La cuenta no tiene los fondos suficiente para realizar la transferencia";
        ROLLBACK;
    END IF;
END
$$



delimiter $$ 
CREATE PROCEDURE retiroSinCuenta(in folioRetiro int,IN emisor INT,IN montoRetiro DECIMAL(10, 2))
begin 
     DECLARE saldo_origen DECIMAL(10, 2);
	START TRANSACTION;
    SELECT monto INTO saldo_origen FROM cuentas WHERE numero_cuenta = emisor FOR UPDATE;
    IF (saldo_origen >= montoRetiro) THEN
    UPDATE cuentas SET monto = monto - montoRetiro WHERE numero_cuenta = emisor;
    Update retirosSinCuenta set monto = montoRetiro,Estado = "Cobrado" Where folio = folioRetiro;
       COMMIT;
    ELSE
        ROLLBACK;
    END IF;
END
$$

delimiter $$
CREATE PROCEDURE cambiar_estado_retiro_sin_cuenta(in folioRetiro int)
BEGIN
    DECLARE estado_retiro varchar(20);
    DECLARE registro_time DATETIME;
    DECLARE actual_time DATETIME;
    DECLARE tiempo_transcurrido INT;
    Select estado from retirossincuenta WHERE folio = folioRetiro into estado_retiro;
    SELECT fecha FROM retirossincuenta WHERE folio = folioRetiro INTO registro_time;
    SET actual_time = NOW();
    SET tiempo_transcurrido = TIMESTAMPDIFF(MINUTE, registro_time, actual_time);
    IF tiempo_transcurrido > 10 and estado_retiro like "Pendiente" THEN
        UPDATE retirossincuenta SET estado = 'no cobrado' WHERE folio = folioRetiro;
    END IF;
END
$$



delimiter $$
CREATE PROCEDURE depositos(in cuenta int,in numeroElementos int,in elemntosSaltar int ,in fechaInicio date,in fechaFinal date)
begin 
select depositosacuenta.id, depositosacuenta.monto, depositosacuenta.fecha from cuentas
inner join depositosacuenta on depositosacuenta.cuenta_depositada = numero_cuenta
where numero_cuenta = cuenta and  depositosacuenta.fecha between fechaInicio and  fechaFinal order by depositosacuenta.fecha desc limit numeroElementos offset elemntosSaltar;
end;
$$










