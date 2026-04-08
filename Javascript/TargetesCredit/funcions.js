function calcularControl() {
    var entitat = document.getElementById("entitat");
    var agencia = document.getElementById("agencia");
    var compte = document.getElementById("compte");
    var numIban = document.getElementById("iban");
    var control=document.getElementById("control");
    function calcularDigitControl(entitat, agencia, compte) {
        var digitControl = "";
        function digitEntitat(entitat, agencia) {
            var numEntitatAgencia = entitat.toString()+agencia.toString();
            var controlEntitat = 0;
            var residu = 0;
            for (var compt = 0; compt < numEntitatAgencia.length; compt++) {
                var multi = Math.pow(2, compt+2)%11;
                residu += multi*numEntitatAgencia[compt];
            }
            controlEntitat = 11-(residu%11);
            if (controlEntitat === 10) { controlEntitat = 1; }
            controlEntitat = controlEntitat%11;
            return controlEntitat;
        }
        function digitCompte(compte) {
            var controlCompte = 0;
            var residu = 0;
            for (var compt = 0; compt < compte.length; compt++) {
                var multi = Math.pow(2, compt)%11;
                residu += multi*compte[compt];
            }
            controlCompte = 11-(residu%11);
            if (controlCompte === 10) { controlCompte = 1; }
            controlCompte = controlCompte%11;
            return controlCompte;
        }
        digitControl += digitEntitat(entitat, agencia).toString() + digitCompte(compte).toString();
        return digitControl;
    }
    control.value = calcularDigitControl(entitat.value, agencia.value, compte.value);
    function calcularIban(entitat, agencia, control, compte) {
        var residu = "";
        var numSencer = entitat.toString()+agencia.toString()+control.toString()+compte.toString()+"142800";
        for (var compt = 0; compt < numSencer.length; compt++) {
            var num = numSencer[compt].toString();
            residu = residu.toString()+num;
            residu = parseInt(residu%97);
        }
        var iban = 98-residu;
        if (iban < 10) { iban = "0"+iban.toString();  }
        return iban;
    }
    numIban.value = calcularIban(entitat.value, agencia.value, control.value, compte.value);
}
function validarTargeta() {
    var targeta = document.getElementById("targeta").value;
    var validar = document.getElementById("validar");
    var valid = 0;
    for (var compt = 0; compt < targeta.length; compt++) {
        var producte = 0;
        if (compt % 2 === 0) {
            producte = (targeta[compt]*2).toString();
            if (producte.length > 1) { producte = parseInt(producte[0])+parseInt(producte[1]); }
        }
        else { producte = targeta[compt]; }
        valid += parseInt(producte);
    }
    if (valid % 10 === 0) { validar.innerHTML = "El número de la targeta és vàlid!"; }
    else { validar.innerHTML = "El número de la targeta no és vàlid! D:<"; }
}