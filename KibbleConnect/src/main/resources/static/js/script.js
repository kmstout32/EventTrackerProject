window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();

});

function init() {

	console.log('in init')
	
	loadAllKibbles();
	loadAllBrands();
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
function loadAllBrands() {
	//XHR 
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/brands');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200) {
				let brandList = JSON.parse(xhr.responseText);
				console.log(brandList);
				displayKibbleBrands(brandList);
			}
		}
	};
	xhr.send();


}

function displayAllKibbles(kibbleList) {
	//DOM Stuff
	let tbody = document.getElementById('kibbleTableBody');
	tbody.textContent = '';
	for(let kibble of kibbleList){
		let tr = document.createElement('tr');
		tbody.appendChild(tr);
		tr.addEventListener('click', function(event){
			event.preventDefault();
			let kibbleId = event.target.parentElement.firstElementChild.textContent;
			console.log(kibbleId);
			
			
			
		});
		let td = document.createElement('td')
		td.textContent = kibble.id;
		tr.appendChild(td);
		td = document.createElement('td');
		td.textContent = kibble.brand.name;
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
		img.setAttribute('src', kibble.kibbleUrl );
		img.classList.add('kibbleImgThumbNail')
		td.appendChild(img);
		tr.appendChild(td);
		
	}
}

function displayKibbleBrands(brands) {
	let brandDiv = document.getElementById('brandData');
	//brandDiv.textContent = '';
	if (brands && brands.length) {
		let h2 = document.createElement('h2');
		h2.textContent = "Brand:";
		brandDiv.appendChild(h2);
		let ul = document.createElement('ul');
		brandDiv.appendChild(ul);
		for (let brand of brands) {
			let li = document.createElement('li');
			li.textContent = brand.name;
			ul.appendChild(li);
		}
	}
}

function addNewKibbles(newKibble) {
	let xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/kibbles');
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4) {
			if (xhr.status === 200 || xhr.readyState === 201) {
				let kibble = JSON.parse(xhr.responseText);
				displayFilm(kibble);
			}
			else {
				displayError('Error creating log: ' + xhr.status);
			}
		}
	};
	
	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body
	let newKibbleJson = JSON.stringify(newKibble);
	xhr.send(newKibbleJson); //FIXME
}

//Method returns one by ID
function getKibbleById(kibbleId){
	let xhr = new XMLHttpRequest();
	xhr.open('GET', 'api/kibbles/'+kibbleId);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4){
			if(xhr.status ===200){
				let kibble = JSON.parse(xhr.responseText);
				displayKibble(kibble);
			}
		}
	};
	xhr.send();
}

function displayKibble(kibble){
	let detailDiv = document.getElementById('kibbleDetails');
	detailDiv.textContent = '';
	let h2 = document.createElement('h2');
	h2.textContent = kibble.name;
	detailDiv.appendChild(h2);
}


















