# 🔧 AutoWizards | Sistema de Gestión de Taller Mecánico

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.0-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Green-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white)
![Status](https://img.shields.io/badge/Status-Stable-success?style=for-the-badge)

> **AutoWizards** es una plataforma integral basada en **Arquitectura Hexagonal** diseñada para la administración eficiente de talleres automotrices. Gestiona citas, inventarios, órdenes de servicio, facturación y seguimiento de garantías mediante una interfaz moderna y responsiva.

---

## 📋 Tabla de Contenidos
1. [Requisitos del Sistema](#-requisitos-del-sistema)
2. [Instalación en Debian/Ubuntu](#-instalación-en-debianubuntu)
3. [Configuración de Base de Datos](#-configuración-de-base-de-datos)
4. [Compilación y Despliegue](#-compilación-y-despliegue)
5. [Credenciales de Acceso](#-credenciales-de-acceso)
6. [Arquitectura](#-arquitectura)

---

## 💻 Requisitos del Sistema

Para levantar este proyecto en un entorno Linux (Debian 12/13, Ubuntu 22.04/24.04), asegúrate de tener:

* **Sistema Operativo:** Linux (Preferente Debian/Ubuntu Server)
* **Java JDK:** Versión 21 (Obligatorio)
* **Maven:** Versión 3.8 o superior
* **Base de Datos:** PostgreSQL 14 o superior

---

## 🚀 Instalación en Debian/Ubuntu

Sigue estos pasos en tu terminal para preparar el entorno desde cero.

### 1. Actualizar repositorios e instalar dependencias
```bash
sudo apt update && sudo apt upgrade -y
sudo apt install openjdk-21-jdk maven postgresql postgresql-contrib -y
```
### 2.Verificar instalaciones
```bash 
java -version   # Debe decir "build 21..."
mvn -version
psql --version
```
##  🗄️ Configuracion de Base de Datos
### 1. Iniciar Servicio PostgreSQL (Si no esta corriendo)
```bash 
sudo systemctl start postgresql
sudo systemctl enable postgresql
```
### Ejecuta los siguientes comandos SQL dentro de la consola postgres=#:
```SQL
-- Crear base de datos
CREATE DATABASE taller;
 -- Configurar contraseña del usuario postgres (Opcional si usas otra credencial)
-- Nota: Asegúrate que coincida con src/main/resources/application.properties
ALTER USER postgres WITH PASSWORD 'postgres';

-- Salir
\q
```
## 🛠️ Compilación y Despliegue
### 1. Clonar el repositorio
```bash 
git clone https://github.com/Vidruck/tallerMec.git
cd AutoWizards
```
### 2.Compilar el Proyecto
```bash 
mvn clean install -DskipTests
```
####     Deberías ver un mensaje de [INFO] BUILD SUCCESS.
### 3. Ejecutar la aplicación
#### Opción A Desarrollo:
```bash 
mvn spring-boot:run
```
#### Opción B (Producción/Segundo plano):
```bash 
java -jar target/tallerMec-0.0.1-SNAPSHOT.jar
```
#### La aplicación iniciará en el puerto 8080.

## 🔐 Credenciales de Acceso
#### Una vez levantado, accede desde tu navegador a: http://localhost:8080 (o la IP de tu servidor).
### Rol,Usuario Administrador:
### (Email) admin@autowizards.com, Contraseña  admin

## 🏗️ Arquitectura
### Este proyecto sigue los principios de Arquitectura Hexagonal (Puertos y Adaptadores) para garantizar el desacoplamiento y la mantenibilidad:
* Domain (Núcleo): Lógica de negocio pura (Entidades JPA).
* Input Ports: Interfaces que definen los casos de uso (Servicios).
* Output Ports: Interfaces para la persistencia de datos.
* Adapters:
  * Web (MVC): Controladores Thymeleaf.
  * Persistence: Repositorios JPA/Hibernate.
   
  
## 👨‍💻 Autor
### Desarrollado por Alejandro González Hernández para la materia de Ingeniería de Software. © 2026 Raven
