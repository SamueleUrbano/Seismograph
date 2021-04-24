const chart_xAsix_canvas = document.getElementById('x_asix-chart').getContext('2d');
const chart_yAsix_canvas = document.getElementById('y_asix-chart').getContext('2d');
const chart_zAsix_canvas = document.getElementById('z_asix-chart').getContext('2d');

let xAsix_chart = null;
let yAsix_chart = null;
let zAsix_chart = null;

let xAsix = Array();
let yAsix = Array();
let zAsix = Array();

let genericObjectData = null;
let forNullLabel = Array();

$.ajax(
    {
        type: "GET",
        url: "http://192.168.1.12:8080/vabSeismograph_war_exploded/restServices/seismographData/getLastData",
        dataType: "json",
        success: function(response) {
            for (index in response) {
                date.push(response[index].date);

                genericObjectData = {x: Date.parse(response[index].date), y: response[index].xAsix};
                xAsix.push(genericObjectData);
                genericObjectData = {x: Date.parse(response[index].date), y: response[index].yAsix};
                yAsix.push(genericObjectData);
                genericObjectData = {x: Date.parse(response[index].date), y: response[index].zAsix};
                zAsix.push(genericObjectData);
                forNullLabel.push("");
            }

            // xAsix chart
            var xAsixReversed = xAsix.reverse();
            xAsix_chart = new Chart(
                chart_xAsix_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: xAsixReversed,
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
                        scales: {
                            xAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }],
                            yAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }]
                        },
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

            var yAsixReversed = yAsix.reverse();
            xAsix_chart = new Chart(
                chart_yAsix_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: yAsixReversed,
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
                        scales: {
                            xAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }],
                            yAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }]
                        },
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

            var zAsixReversed = zAsix.reverse();
            xAsix_chart = new Chart(
                chart_zAsix_canvas,
                {
                    type: 'line',
                    data: {
                        labels: forNullLabel,
                        datasets: [
                            {
                                label: "",
                                data: zAsixReversed,
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
                        scales: {
                            xAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }],
                            yAxes: [{
                                gridLines: {
                                    display: false
                                }
                            }]
                        },
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