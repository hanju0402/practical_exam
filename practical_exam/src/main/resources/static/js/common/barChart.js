/**
 * Chart.js 
 */

// 바 차트 [element-id(text) , title(text) , 레이블(배열), 데이터[배열] ]
function barChart(eleId, title, labels, data, color) {
	let chartArea = document.getElementById(eleId).getContext('2d');

	let myChart = new Chart(chartArea, {
		// ①차트의 종류(String)
		type: 'bar',
		// ②차트의 데이터(Object)
		data: {
			labels: labels,
			datasets: [{
				data: data,
				backgroundColor: color,
				borderColor: 'rgba(255, 99, 132, 1)',
				borderWidth: 1
			}]
		},
		// ⑩차트의 설정(Object)
		options: {
			plugins: {
				title: {
					display: true,
					text: title
				}
			},
			scales: {
				yAxes: [{
					ticks: {
						stepSize: 10, //y축 간격
						suggestedMin: 0,//y축 최소 값
						suggestedMax: 100,//y축 최대값
					},
					gridLines: {//y축 라인 스타일 설정
						borderDash: [2, 2],
						borderDashOffset: 0.2
					}
				}],
				xAxes: [{//x축 설정
					ticks: {
						
					}
				}]
			}
		}
	});
}
// 라인차트
function lineChart(eleId, title, labels,labelsInfo1, labelsInfo2, data1, data2) {
	let chartArea = document.getElementById(eleId);
	
	let myChart = new Chart(chartArea, {
		type: 'line',
		data: {
			labels: labels,
			datasets: [
				{
					label: labelsInfo1,
					data: data1,
					backgroundColor: 'yellow',
					borderColor: 'black',
					borderWidth: 1
				},
				{
					label: labelsInfo2,
					data: data2,
					backgroundColor: 'white',
					borderColor: 'gray',
					borderWidth: 1
				}
			]
		},
		scales: {
			yAxes: [{
				ticks: {
					stepSize: 10, //y축 간격
					suggestedMin: 0,//y축 최소 값
					suggestedMax: 100,//y축 최대값
				},
				gridLines: {//y축 라인 스타일 설정
					borderDash: [2, 2],
					borderDashOffset: 0.2
				}
			}],
			xAxes: [{//x축 설정
				ticks: {
					
				}
			}]
		}
	});
}