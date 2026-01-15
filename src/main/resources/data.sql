-- ==========================================
-- CARGA INICIAL DE DATOS (CATÁLOGOS)
-- ==========================================

-- Insertar Departamentos Base (Si no existen)
INSERT INTO departamentos (nombre, descripcion)
VALUES
    ('ADMINISTRACION', 'Oficina central y gestión'),
    ('MECANICA_GENERAL', 'Reparaciones generales de motor y servicios'),
    ('PINTURA', 'Hojalatería y pintura automotriz'),
    ('FRENOS', 'Sistema de frenado y suspensión')
    ON CONFLICT (nombre) DO NOTHING;

-- Nota: El usuario 'ADMIN' se crea desde la aplicación Java (DataInitializer)
-- para asegurar que la contraseña se encripte correctamente con BCrypt.