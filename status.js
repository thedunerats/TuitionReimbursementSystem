function getStatus(){
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
				let reqdecision = document.createElement("td");
				reqdecision.innerHTML = r["reqdecision"];
				let decider = document.createElement("td");
                decider.innerHTML = r["decider"];
                let empinfo = document.createElement("td");
                empinfo.innerHTML = r["empinfo"];
                let supervisorinfo = document.createElement("td");
                supervisorinfo.innerHTML = r["supervisorinfo"];
                let depheadinfo = document.createElement("td");
                depheadinfo.innerHTML = r["depheadinfo"];
                let reimbursement = document.createElement("td");
                reimbursement.innerHTML = r["reimbursement"];
                let reason = document.createElement("td");
                reason.innerHTML = r["reason"];
                let isexceeding = document.createElement("td");
                isexceeding.innerHTML = r["isexceeding"];
                let supervisordecision = document.createElement("td");
                supervisordecision.innerHTML = r["supervisordecision"];
                let headdecision = document.createElement("td");
                headdecision.innerHTML = r["headdecision"];
                let bencodecision = document.createElement("td");
                bencodecision.innerHTML = r["bencodecision"];
                let occupationid = document.createElement("td");
                occupationid.innerHTML = m["occupationid"];
				row.appendChild(reqId);
				row.appendChild(reqdecision);
				row.appendChild(decider);
                row.appendChild(empinfo);
                row.appendChild(supervisorinfo);
                row.appendChild(depheadinfo);
                row.appendChild(reimbursement);
                row.appendChild(reason);
                row.appendChild(isexceeding);
                row.appendChild(supervisordecision);
                row.appendChild(headdecision);
                row.appendChild(bencodecision);
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