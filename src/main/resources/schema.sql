-- ==========================================
-- ESTRUCTURA DE TABLAS: TALLER MECÁNICO (PostgreSQL)
-- ==========================================

-- 1. Tabla Clientes
CREATE TABLE IF NOT EXISTS clientes (
                                        id_cliente VARCHAR(15) NOT NULL, -- RFC o INE
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
    id_cliente VARCHAR(15) NOT NULL,

    CONSTRAINT pk_vehiculos PRIMARY KEY (id_vehiculo),
    CONSTRAINT uq_vehiculos_vin UNIQUE (numero_serie),
    CONSTRAINT uq_vehiculos_placas UNIQUE (placas),
    CONSTRAINT fk_vehiculos_clientes FOREIGN KEY (id_cliente)
    REFERENCES clientes(id_cliente)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );

CREATE INDEX IF NOT EXISTS idx_vehiculos_cliente ON vehiculos(id_cliente);

-- 3. Tabla Departamentos (Catálogo interno)
CREATE TABLE IF NOT EXISTS departamentos (
                                             id_departamento SERIAL NOT NULL, -- SERIAL equivale a AUTO_INCREMENT
                                             nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(200),

    CONSTRAINT pk_departamentos PRIMARY KEY (id_departamento),
    CONSTRAINT uq_departamentos_nombre UNIQUE (nombre)
    );

-- 4. Tabla Usuarios (Personal y Clientes con acceso web)
CREATE TABLE IF NOT EXISTS usuarios (
                                        id_usuario VARCHAR(10) NOT NULL, -- UUID corto o No. Empleado
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL,
    password VARCHAR(128) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    id_departamento INT, -- Nulo para Clientes

    CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario),
    CONSTRAINT uq_usuarios_email UNIQUE (email),

    -- Validación de Roles permitidos
    CONSTRAINT chk_usuarios_rol CHECK (rol IN ('ADMIN', 'JEFE_AREA', 'TRABAJADOR', 'CLIENTE')),

    CONSTRAINT fk_usuarios_departamento FOREIGN KEY (id_departamento)
    REFERENCES departamentos(id_departamento)
    ON DELETE SET NULL
    );

-- 5. Tabla Ordenes de Servicio
CREATE TABLE IF NOT EXISTS ordenes_servicio (
                                                id_orden BIGSERIAL NOT NULL, -- BIGSERIAL para IDs autoincrementables grandes
                                                fecha_ingreso TIMESTAMP NOT NULL DEFAULT NOW(),
    fecha_salida TIMESTAMP,
    estado VARCHAR(20) NOT NULL, -- 'EN_TALLER', 'FINALIZADO', etc.
    descripcion_problema VARCHAR(500),
    id_vehiculo VARCHAR(15) NOT NULL,
    id_usuario VARCHAR(10) NOT NULL, -- Asesor que recibió el auto

    CONSTRAINT pk_ordenes PRIMARY KEY (id_orden),

    CONSTRAINT fk_ordenes_vehiculo FOREIGN KEY (id_vehiculo)
    REFERENCES vehiculos(id_vehiculo)
    ON DELETE RESTRICT,

    CONSTRAINT fk_ordenes_usuario FOREIGN KEY (id_usuario)
    REFERENCES usuarios(id_usuario)
    ON DELETE RESTRICT
    );

CREATE INDEX IF NOT EXISTS idx_ordenes_estado ON ordenes_servicio(estado);
CREATE INDEX IF NOT EXISTS idx_ordenes_vehiculo ON ordenes_servicio(id_vehiculo);

-- 6. Tabla Reparaciones (Detalle de la Orden)
CREATE TABLE IF NOT EXISTS reparaciones (
                                            id_reparacion BIGSERIAL NOT NULL,
                                            descripcion VARCHAR(1000) NOT NULL,
    costo DOUBLE PRECISION NOT NULL, -- Postgres usa DOUBLE PRECISION
    fecha_reparacion DATE,
    id_orden BIGINT NOT NULL,

    CONSTRAINT pk_reparaciones PRIMARY KEY (id_reparacion),
    CONSTRAINT fk_reparaciones_orden FOREIGN KEY (id_orden)
    REFERENCES ordenes_servicio(id_orden)
    ON DELETE CASCADE
    );

-- 7. Tabla Facturas
CREATE TABLE IF NOT EXISTS facturas (
                                        id_factura VARCHAR(36) NOT NULL, -- UUID largo
    fecha_emision TIMESTAMP NOT NULL DEFAULT NOW(),
    monto_total DOUBLE PRECISION NOT NULL,
    rfc_cliente VARCHAR(13) NOT NULL,
    archivo_pdf VARCHAR(255),
    id_orden BIGINT NOT NULL,

    CONSTRAINT pk_facturas PRIMARY KEY (id_factura),
    CONSTRAINT fk_facturas_orden FOREIGN KEY (id_orden)
    REFERENCES ordenes_servicio(id_orden)
    );

-- 8. Tabla Garantías
CREATE TABLE IF NOT EXISTS garantias (
                                         id_garantia VARCHAR(36) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE NOT NULL,
    cobertura VARCHAR(500) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    id_reparacion BIGINT NOT NULL,

    CONSTRAINT pk_garantias PRIMARY KEY (id_garantia),
    CONSTRAINT fk_garantias_reparacion FOREIGN KEY (id_reparacion)
    REFERENCES reparaciones(id_reparacion)
    );