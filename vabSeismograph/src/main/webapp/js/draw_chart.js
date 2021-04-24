const chart_xAxis_canvas = document.getElementById('x_axis-chart').getContext('2d');
const chart_yAxis_canvas = document.getElementById('y_axis-chart').getContext('2d');
const chart_zAxis_canvas = document.getElementById('z_axis-chart').getContext('2d');

let xAxis_chart = null;
let yAxis_chart = null;
let zAxis_chart = null;

let xAxis = Array();
let yAxis = Array();
let zAxis = Array();

let genericObjectData = null;
let forNullLabel = Array();

// AJAX call
$.ajax(
    {
        type: "GET",
        url: "api_link",
        dataType: "json",
        success: function(response) {
            for (let index in response) {
                genericObjectData = {x: Date.parse(response[index].date), y: response[index].xAxis};
                xAxis.push(genericObjectData);
                genericObjectData = {x: Date.parse(response[index].date), y: response[index].yAxis};
                yAxis.push(genericObjectData);
                genericObjectData = {x: Date.parse(response[index].date), y: response[index].zAxis};
                zAxis.push(genericObjectData);
                forNullLabel.push("");
            }

            // xAxis chart
            let xAxisReversed = xAxis.reverse();
            xAxis_chart = new Chart(
                chart_xAxis_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: xAxisReversed,
                                backgroundColor: [
                                    'rgba(255, 15, 52, 0.2)',
                                ],
                                borderColor: [
                                    'rgb(255, 15, 52)'
                                ],
                                borderWidth: 1
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        elements: {
                            point: {
                                radius: 0
                            }
                        }
                    }
                }
            );

            // yAxis chart
            let yAxisReversed = yAxis.reverse();
            yAxis_chart = new Chart(
                chart_yAxis_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: yAxisReversed,
                                backgroundColor: [
                                    'rgba(57, 134, 8, 0.2)',
                                ],
                                borderColor: [
                                    'rgb(57, 134, 8)'
                                ],
                                borderWidth: 1
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        elements: {
                            point: {
                                radius: 0
                            }
                        }
                    }
                }
            );

            var zAxisReversed = zAxis.reverse();
            zAxis_chart = new Chart(
                chart_zAxis_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: zAxisReversed,
                                backgroundColor: [
                                    'rgba(21, 86, 173, 0.2)',
                                ],
                                borderColor: [
                                    'rgb(21, 86, 173)'
                                ],
                                borderWidth: 1
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        maintainAspectRatio: false,
                        elements: {
                            point: {
                                radius: 0
                            }
                        }
                    }
                }
            );
        },
        error: function() {
            console.log('Data not received.');
        }
    }
);