<?php class cella extends taula {
    private $informacio;
    private $color;
    private $fons;
    
    public function getInformacio() {
        return $this->informacio;
    }

    public function getColor() {
        return $this->color;
    }

    public function getFons() {
        return $this->fons;
    }
    
    public function setInformacio($informacio) {
        $this->informacio = $informacio;
    }

    public function setColor($color) {
        $this->color = $color;
    }

    public function setFons($fons) {
        $this->fons = $fons;
    }
    
    public function inserirInformacio($informacio) {
        $this->setInformacio($informacio);
    }
    
    public function colorLletra($color) {
        $this->setColor($color);
    }
    
    public function colorFons($fons) {
        $this->setFons($fons);
    }
        
    public function __construct($fila, $columna) {
        $this->setFiles($fila);
        $this->setColumnes($columna);
    }

    
}