document.addEventListener('DOMContentLoaded', () => {
    initCharts();
});

function initCharts() {
    // 1. Extraer datos del DOM (Ingresos)
    const ingresosLabels = [];
    const ingresosValues = [];
    document.querySelectorAll('#data-ingresos .data-point').forEach(el => {
        ingresosLabels.push(el.dataset.label);
        ingresosValues.push(el.dataset.value);
    });

    // 2. Extraer datos del DOM (Mecánicos)
    const mecLabels = [];
    const mecValues = [];
    document.querySelectorAll('#data-mecanicos .data-point').forEach(el => {
        mecLabels.push(el.dataset.label);
        mecValues.push(el.dataset.value);
    });

    // Configuración de Colores (Catppuccin + Breeze)
    const colorPrimary = '#3daee9';
    const colorSuccess = '#40a02b';
    const colorWarning = '#df8e1d';
    const colorDanger  = '#d20f39';

    // 3. Renderizar Gráfico de Barras (Ingresos)
    const ctxIngresos = document.getElementById('chartIngresos');
    if (ctxIngresos) {
        new Chart(ctxIngresos.getContext('2d'), {
            type: 'bar',
            data: {
                labels: ingresosLabels,
                datasets: [{
                    label: 'Ingresos ($)',
                    data: ingresosValues,
                    backgroundColor: colorPrimary,
                    borderRadius: 6,
                    borderWidth: 1,
                    borderColor: '#ffffff'
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { display: false }
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        grid: { color: 'rgba(200, 200, 200, 0.1)' }
                    },
                    x: {
                        grid: { display: false }
                    }
                }
            }
        });
    }

    // 4. Renderizar Gráfico de Dona (Mecánicos)
    const ctxMec = document.getElementById('chartMecanicos');
    if (ctxMec) {
        new Chart(ctxMec.getContext('2d'), {
            type: 'doughnut',
            data: {
                labels: mecLabels,
                datasets: [{
                    data: mecValues,
                    backgroundColor: [colorPrimary, colorSuccess, colorWarning, colorDanger],
                    borderWidth: 2,
                    borderColor: getComputedStyle(document.body).getPropertyValue('--ctp-mantle')
                }]
            },
            options: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: { position: 'bottom', labels: { usePointStyle: true } }
                }
            }
        });
    }
}