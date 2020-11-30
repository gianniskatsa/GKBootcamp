

function enableStudentFields() {
    var x = document.getElementById("myinput").disabled
    if (x === true) {
        document.getElementById("myinput").disabled = false;
        document.getElementById("myinput1").disabled = false;
        document.getElementById("myinput5").disabled = false;
        document.getElementById("myinput3").disabled = false;
    } else {
        document.getElementById("myinput").disabled = true;
        document.getElementById("myinput1").disabled = true;
        document.getElementById("myinput5").disabled = true;
        document.getElementById("myinput3").disabled = true;
    }
}

function enableSimpleAssignmentFields() {
    var x = document.getElementById("myinput").disabled
    if (x === true) {
        document.getElementById("myinput").disabled = false;
        document.getElementById("myinput1").disabled = false;
        document.getElementById("myinput3").disabled = false;
        document.getElementById("myinput4").disabled = false;
        document.getElementById("myinput5").disabled = false;
    } else {
        document.getElementById("myinput").disabled = true;
        document.getElementById("myinput1").disabled = true;
        document.getElementById("myinput3").disabled = true;
        document.getElementById("myinput4").disabled = true;
        document.getElementById("myinput5").disabled = true
    }
}

function enableFields() {
    var x = document.getElementById("myinput").disabled
    if (x === true) {
        document.getElementById("myinput").disabled = false;
        document.getElementById("myinput1").disabled = false;
        document.getElementById("myinput2").disabled = false;
        document.getElementById("myinput3").disabled = false;
        document.getElementById("myinput4").disabled = false;
        document.getElementById("myinput5").disabled = false;
        document.getElementById("myinput6").disabled = false;
        document.getElementById("myinput7").disabled = false;
        document.getElementById("myinput8").disabled = false;
        document.getElementById("myinput9").disabled = false;
        document.getElementById("myinput10").disabled = false;
        document.getElementById("myinput11").disabled = false;
        document.getElementById("myinput12").disabled = false;
        document.getElementById("myinput13").disabled = false;


    } else {
        document.getElementById("myinput").disabled = true;
        document.getElementById("myinput1").disabled = true;
        document.getElementById("myinput2").disabled = true;
        document.getElementById("myinput3").disabled = true;
        document.getElementById("myinput4").disabled = true;
        document.getElementById("myinput5").disabled = true
        document.getElementById("myinput6").disabled = true;
        document.getElementById("myinput7").disabled = true;
        document.getElementById("myinput8").disabled = true;
        document.getElementById("myinput9").disabled = true;
        document.getElementById("myinput10").disabled = true;
        document.getElementById("myinput11").disabled = true;
        document.getElementById("myinput12").disabled = true;
        document.getElementById("myinput13").disabled = true;


    }
}

function submitSuccess() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var z = document.getElementById("myinput2").value
    if (x.length > 3 && y.length > 3 && z.length > 3) {
        alert("Your input " + x + " " + y + " " + z + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}
function submitSuccessT() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var z = document.getElementById("myinput2").value
    var valueDate2 = document.getElementById("myinput5").value
    var valueDate3 = document.getElementById("myinput6").value

    if (x.length > 3 && y.length > 3 && z.length > 3&& Date.parse(valueDate2)
        && Date.parse(valueDate3) && Date.parse(valueDate2) < Date.parse(valueDate3)) {
        alert("Your input " + x + " " + y + " " + z + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}


function submitSuccessC() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var z = document.getElementById("myinput2").value
    var valueDate = document.getElementById("myinput3").value
    var valueDate2 = document.getElementById("myinput4").value
    if (x.length > 3 && y.length > 3 && z.length > 3 && Date.parse(valueDate)
        && Date.parse(valueDate2) && Date.parse(valueDate) < Date.parse(valueDate2)) {
        alert("Your input " + x + " " + y + " " + z + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

function submitSuccessD() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var z = document.getElementById("myinput5").value
    var valueDate = document.getElementById("myinput3").value
    if (x.length > 3 && y.length > 3 && z > 100 && Date.parse(valueDate)) {
        alert("Your input " + x + " " + y + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

function submitSuccessE() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var z = document.getElementById("myinput3").value
    var a = document.getElementById("myinput4").value


    var valueDate = document.getElementById("myinput5").value
    if (x.length > 3 && y.length > 3 && z > 10 && a > 10 && Date.parse(valueDate)) {
        alert("Your input " + x + " " + y + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

function submitSuccessF() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var b = document.getElementById("myinput2").value
    var c = document.getElementById("myinput3").value
    var p = document.getElementById("myinput4").value
    var f = document.getElementById("myinput7").value
    var g = document.getElementById("myinput8").value
    var valueDate2 = document.getElementById("myinput5").value
    var valueDate3 = document.getElementById("myinput6").value
    var valueDate = document.getElementById("myinput9").value
    if (x.length > 3 && y.length > 3 && b.length > 3 && c.length > 3 && p.length > 3 && f > 10 && g > 10
        && Date.parse(valueDate) && Date.parse(valueDate2) && Date.parse(valueDate3)
        && Date.parse(valueDate2) < Date.parse(valueDate3)) {
        alert("Your input " + x + " " + y + " " + b + " " + c + " " + p + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

function submitSuccessG() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var b = document.getElementById("myinput2").value
    var c = document.getElementById("myinput3").value
    var p = document.getElementById("myinput4").value
    var f = document.getElementById("myinput7").value
    var g = document.getElementById("myinput8").value
    var i = document.getElementById("myinput12").value
    var u = document.getElementById("myinput10").value
    var t = document.getElementById("myinput11").value
    var valueDate4 = document.getElementById("myinput13").value
    var valueDate2 = document.getElementById("myinput5").value
    var valueDate3 = document.getElementById("myinput6").value
    var valueDate = document.getElementById("myinput9").value
    if (x.length > 3 && y.length > 3 && b.length > 3 && c.length > 3 && p.length > 3 && i > 10 && f > 10 && g > 10
        && Date.parse(valueDate) && Date.parse(valueDate2) && Date.parse(valueDate3) && Date.parse(valueDate4)
        && Date.parse(valueDate2) < Date.parse(valueDate3)) {
        alert("Your input " + x + " " + u + " " + t + " " + b + " " + c + " " + p + " " + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

function submitSuccessH() {
    var x = document.getElementById("myinput").value
    var y = document.getElementById("myinput1").value
    var b = document.getElementById("myinput2").value
    var c = document.getElementById("myinput3").value
    var p = document.getElementById("myinput4").value

    var t = document.getElementById("myinput7").value

    var valueDate2 = document.getElementById("myinput5").value
    var valueDate3 = document.getElementById("myinput6").value
    var valueDate = document.getElementById("myinput8").value
    if (x.length > 3 && y.length > 3 && b.length > 3 && p.length > 3
        && c.length > 3 && t > 3 && Date.parse(valueDate) && Date.parse(valueDate2)
        && Date.parse(valueDate3) && Date.parse(valueDate2) < Date.parse(valueDate3)) {
        alert("Your input " + x + " " + y + " " + b + " " + c + " " + p + " " + " has been successfully submitted");
        return true;
    } else {
        alert("Please input the correct details!")
        return false;
    }
}

var item = document.getElementById("edit");
item.addEventListener("mouseover", func, false);

function func() {
    item.setAttribute("style", "background-color:blue;")
}