function getRequests(){
	let url = "/ServletDemo/getflix/api/movies"; //FIXME: change this.
	let xhr = new XMLHttpRequest();
	let body = document.getElementById("bodied");
	
	xhr.onreadystatechange = function(){
		if(xhr.status === 200 && xhr.readyState === 4){
			let requests = JSON.parse(xhr.responseText);
			
			for(let r of requests){
				let row = document.createElement("tr");
				let reqId = document.createElement("td"); 
				reqId.innerHTML = r["reqid"];
				let empID = document.createElement("td");
				empID.innerHTML = r["empid"];
				let submitdate = document.createElement("td");
                submitdate.innerHTML = r["submitdate"];
                let tuition = document.createElement("td");
                tuition.innerHTML = r["tuition"];
                let description = document.createElement("td");
                description.innerHTML = r["submitdate"];
                let status = document.createElement("td");
                status.innerHTML = r["submitdate"];
                let passinggrade = document.createElement("td");
                passinggrade.innerHTML = r["passinggrade"];
                let coursetitle = document.createElement("td");
                coursetitle.innerHTML = r["coursetitle"];
                let urgencystatus = document.createElement("td");
                urgencystatus.innerHTML = r["urgencystatus"];
                let daysremaining = document.createElement("td");
                daysremaining.innerHTML = r["daysremaining"];
                let daysmissed = document.createElement("td");
                daysmissed.innerHTML = r["daysmissed"];
                let fees = document.createElement("td");
                fees.innerHTML = r["fees"];
                let coursetype = document.createElement("td");
                coursetype.innerHTML = r["coursetype"];
                let location = document.createElement("td");
                location.innerHTML = r["location"];
                let startdate = document.createElement("td");
                startdate.innerHTML = m["startdate"];
                let gradingformat = document.createElement("td");
                gradingformat.innerHTML = m["gradingformat"];
                let occupationid = document.createElement("td");
                occupationid.innerHTML = m["occupationid"];
				row.appendChild(reqId);
				row.appendChild(empID);
				row.appendChild(submitdate);
                row.appendChild(tuition);
                row.appendChild(description);
                row.appendChild(status);
                row.appendChild(passinggrade);
                row.appendChild(coursetitle);
                row.appendChild(urgencystatus);
                row.appendChild(daysremaining);
                row.appendChild(daysmissed);
                row.appendChild(fees);
                row.appendChild(coursetype);
                row.appendChild(location);
                row.appendChild(startdate);
                row.appendChild(gradingformat);
                row.appendChild(occupationid);
                body.appendChild(row);
			}
		}
	}
	
	xhr.open("GET", url);
    xhr.send();
    

}
window.onload = function() {
	getRequests();
}