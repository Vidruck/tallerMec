-- ==========================================
-- ESTRUCTURA DE TABLAS: CONTROL ACCESO
-- ==========================================

-- 1. Tabla Clientes
CREATE TABLE IF NOT EXISTS clientes (
                                        id_cliente VARCHAR(15) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(250),
    correo VARCHAR(150) NOT NULL,

    CONSTRAINT pk_clientes PRIMARY KEY (id_cliente),
    CONSTRAINT uq_clientes_correo UNIQUE (correo)
    );

-- 2. Tabla Vehiculos
CREATE TABLE IF NOT EXISTS vehiculos (
                                         id_vehiculo VARCHAR(15) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    anio INT NOT NULL,
    color VARCHAR(30),
    numero_serie VARCHAR(17) NOT NULL,
    placas VARCHAR(10) NOT NULL,
    id_cliente VARCHAR(15) NOT NULL, -- Llave foránea

    CONSTRAINT pk_vehiculos PRIMARY KEY (id_vehiculo),
    CONSTRAINT uq_vehiculos_vin UNIQUE (numero_serie),
    CONSTRAINT uq_vehiculos_placas UNIQUE (placas),
    CONSTRAINT fk_vehiculos_clientes FOREIGN KEY (id_cliente)
    REFERENCES clientes(id_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

-- Índices extra para búsquedas rápidas (Opcional pero recomendado)
CREATE INDEX idx_vehiculos_cliente ON vehiculos(id_cliente);