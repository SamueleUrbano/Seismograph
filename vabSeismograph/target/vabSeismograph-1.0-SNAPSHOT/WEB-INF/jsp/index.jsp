<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="it">
    <head>
        <title>Home | Seismograph</title>
        <link rel="stylesheet" href="css/chart.css">
        <link rel="stylesheet" href="css/style.css">

        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Cairo:wght@600&display=swap">

        <!-- Library CDN -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js@3.1.1/dist/chart.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="chart-card">
            <h2>Grafico asse X</h2>
            <div class="chart-dimension">
                <canvas id="x_asix-chart"></canvas>
            </div>
        </div>
        <div class="chart-card">
            <h2>Grafico asse Y</h2>
            <div class="chart-dimension">
                <canvas id="y_asix-chart"></canvas>
            </div>
        </div>
        <div class="chart-card">
            <h2>Grafico asse Z</h2>
            <div class="chart-dimension">
                <canvas id="z_asix-chart"></canvas>
            </div>
        </div>
        <script type="text/javascript" src="js/draw_chart.js"></script>
        <script>
            window.setInterval('refresh()', 20000);
            function refresh() {
                window .location.reload();
            }
        </script>
    </body>
</html>
