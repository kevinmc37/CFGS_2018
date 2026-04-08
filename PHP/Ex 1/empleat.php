<?php class empleat {
    private $nom;
    private $sou;
    
    public function impostos() {
        if ($this->sou > 12000) { return true; }
        else { return false; }
    }
    
    function __construct($nom, $sou) {
        $this->nom = $nom;
        $this->sou = $sou;
    }
}
