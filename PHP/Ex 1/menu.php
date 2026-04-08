<?php class menu {
    private $identificador;
    private $enllaç;
    
    public function afegir($identificador, $enllaç) {
        array_push($this->identificador, $identificador);
        array_push($this->enllaç, $enllaç);
    }
    
    public function horitzontal() {
        for ($compt = 0; $compt < count($this->identificador); $compt++) {
            echo ($compt+1)."- ".$this->identificador[$compt]." - "."<a href='http://".$this->enllaç[$compt]."'>".$this->enllaç[$compt]."</a>&emsp;";
        }
    }
    
    public function vertical() {
        for ($compt = 0; $compt < count($this->identificador); $compt++) {
            echo ($compt+1)."- ".$this->identificador[$compt]." - "."<a href='http://".$this->enllaç[$compt]."'>".$this->enllaç[$compt]."</a><br>";
        }
    }
    
    function __construct() {
        $this->identificador = array();
        $this->enllaç = array();
    }
    
}