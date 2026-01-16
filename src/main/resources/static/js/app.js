/**
 * AutoWizards - App Principal
 * 
 * Este archivo gestiona la lógica global de la interfaz de usuario, incluyendo:
 * - Cambio de tema (Claro/Oscuro).
 * - Visibilidad de contraseñas.
 * - Buscadores en tiempo real para tablas.
 */

document.addEventListener('DOMContentLoaded', () => {
    initThemeToggle();
    initPasswordToggle();
});

/**
 * 1. Inicializa el sistema de cambio de tema.
 * Detecta preferencias del sistema o almacenamiento local.
 */
function initThemeToggle() {
    const toggleBtn = document.getElementById('theme-toggle');
    const html = document.documentElement;
    const icon = toggleBtn ? toggleBtn.querySelector('i') : null;

    // Recuperar tema previo o detectar preferencia del sistema
    const savedTheme = localStorage.getItem('theme');
    const systemDark = window.matchMedia('(prefers-color-scheme: dark)').matches;

    let currentTheme = savedTheme || (systemDark ? 'dark' : 'light');
    applyTheme(currentTheme);

    if (toggleBtn) {
        toggleBtn.addEventListener('click', () => {
            // Alternar tema
            currentTheme = currentTheme === 'light' ? 'dark' : 'light';
            applyTheme(currentTheme);
            localStorage.setItem('theme', currentTheme);
        });
    }

    function applyTheme(theme) {
        html.setAttribute('data-theme', theme);
        if (icon) {
            // Cambiar icono: Luna para modo claro (ir a oscuro), Sol para modo oscuro
            icon.className = theme === 'light' ? 'fa fa-moon-o' : 'fa fa-sun-o';
        }
    }
}

/* --- 2. Visibilidad de Contraseña --- */
function initPasswordToggle() {
    const toggles = document.querySelectorAll('.password-toggle');

    toggles.forEach(toggle => {
        toggle.addEventListener('click', function () {
            // El input es el hermano anterior dentro del .password-wrapper
            const input = this.previousElementSibling;

            if (input && input.tagName === 'INPUT') {
                if (input.type === 'password') {
                    input.type = 'text';
                    this.classList.remove('fa-eye');
                    this.classList.add('fa-eye-slash');
                } else {
                    input.type = 'password';
                    this.classList.remove('fa-eye-slash');
                    this.classList.add('fa-eye');
                }
            }
        });
    });
}
/* --- 3. Buscador en Tiempo Real (Tablas) --- */
document.addEventListener('DOMContentLoaded', () => {
    const searchInput = document.getElementById('tableSearch');
    if (searchInput) {
        searchInput.addEventListener('keyup', function () {
            const filter = this.value.toLowerCase();
            const rows = document.querySelectorAll('.table-custom tbody tr');

            rows.forEach(row => {
                const text = row.textContent.toLowerCase();
                row.style.display = text.includes(filter) ? '' : 'none';
            });
        });
    }
});