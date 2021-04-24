<!--
 * The start JSP, it display the axis charts.
 * @author Samuele Urbano
-->
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
        <!-- xAxis chart -->
        <div class="chart-card">
            <h2>Oscillazione asse X</h2>
            <div class="chart-dimension">
                <canvas id="x_axis-chart"></canvas>
            </div>
        </div>

        <!-- yAxis chart -->
        <div class="chart-card">
            <h2>Oscillazione asse Y</h2>
            <div class="chart-dimension">
                <canvas id="y_axis-chart"></canvas>
            </div>
        </div>

        <!-- zAxis chart -->
        <div class="chart-card">
            <h2>Oscillazione asse Z</h2>
            <div class="chart-dimension">
                <canvas id="z_axis-chart"></canvas>
            </div>
        </div>
        <script type="text/javascript" src="js/draw_chart.js"></script>

        <!-- Refresh this JSP after 20 seconds -->
        <script>
            window.setInterval('refresh()', 20000);
            function refresh() {
                window .location.reload();
            }
        </script>
    </body>
</html>
