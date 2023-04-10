window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();

});

function init() {

	console.log('updated')

	loadAllKibbles();
	let addButton = document.getElementById('addKibbleButton');
	console.log(addButton);
	addButton.addEventListener('click', addNewKibbles);

	document.updateKibbleForm.updateKibbleButton.addEventListener('click', function(event) {
		event.preventDefault();
		let form = document.updateKibbleForm;
		console.log('adding new kibble')

		let updatedKibble = {
			name: form.kibbleName.value,
			kibbleUrl: form.kibbleUrl.value,
			createDate: form.createDate.value,
			result: form.result.value,
			protein: form.protein.value,

		};
		
		let id = form.id.value;
		console.log(id);
		console.log(updatedKibble);
		updateKibble(updatedKibble, id);
	});

document.deleteKibble.deleteKibbleBtn.addEventListener('click', function(event) {
		event.preventDefault();
		let form = document.deleteKibble;
		let kibbleId = form.id.value;
		deleteKibble(kibbleId);
		
});
}

function loadAllKibbles() {
	//XHR 
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/kibbles');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let kibbleList = JSON.parse(xhr.responseText);
				displayAllKibbles(kibbleList);
			}
		}
	};
	xhr.send();


}


function displayAllKibbles(kibbleList) {
	//DOM Stuff
	let tbody = document.getElementById('kibbleTableBody');
	tbody.textContent = '';
	for (let kibble of kibbleList) {
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		tr.addEventListener('click', function(event) {
			event.preventDefault();
			let kibbleId = event.target.parentElement.firstElementChild.textContent;
			console.log(kibbleId);



		});
		let td = document.createElement('td')
		td.textContent = kibble.id;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = kibble.name;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = kibble.protein;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = kibble.createDate;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = kibble.result;
		tr.appendChild(td);
		td = document.createElement('td');
		let img = document.createElement('img');
		//TODO if statement for photos

		img.setAttribute('src', kibble.kibbleUrl);
	
			td.appendChild(img);
	}

}

function addNewKibbles() {
	console.log('adding new kibble')
	let kibbleForm = document.getElementById('newKibbleForm');
	let newKibble = {

		name: kibbleForm.kibbleName.value,
		kibbleUrl: kibbleForm.kibbleUrl.value,
		createDate: kibbleForm.createDate.value,
		result: kibbleForm.result.value,
		protein: kibbleForm.protein.value,

	};

	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/kibbles');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.readyState === 201) {
				let kibble = JSON.parse(xhr.responseText);
				displayKibble(kibble);
			}
			else {
				displayError('Error creating log: ' + xhr.status);
			}
		}
	};

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	let newKibbleJson = JSON.stringify(newKibble);
	xhr.send(newKibbleJson);
}


function updateKibble(updatedKibble, id) {

	let xhr = new XMLHttpRequest();
	xhr.open('PUT', `api/kibbles/${id}`);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.readyState === 201) {
				let kibble = JSON.parse(xhr.responseText);
				displayKibble(kibble);
			}
			else {
				console.log('Error creating log: ' + xhr.status);
			}
		}
	};

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	let updateKibbleJson = JSON.stringify(updatedKibble);
	xhr.send(updateKibbleJson);
}

//Method returns one by ID
function getKibbleById(kibbleId) {
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/kibbles/' + kibbleId);
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let kibble = JSON.parse(xhr.responseText);
				displayKibble(kibble);
			}
		}
	};
	xhr.send();
}

function displayKibble(kibble) {
	let detailDiv = document.getElementById('kibbleDetails');
	detailDiv.textContent = '';
	let h2 = document.getElementsByClassName('header');
	h2.textContent = kibble.name;
	detailDiv.appendChild(h2);
}

function displayError(errorMsg){
	
}

function deleteKibble(kibbleId){
	let xhr = new XMLHttpRequest();
	xhr.open('DELETE', 'api/kibbles/' + kibbleId);
	xhr.onreadystatechange = function(){
		
	}
		xhr.send();
}













