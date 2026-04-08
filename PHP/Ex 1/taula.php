<?php require_once("./cella.php");
class taula {
    private $files;
    private $columnes;
    private $cella;
    
    public function getFiles() {
        return $this->files;
    }

    public function getColumnes() {
        return $this->columnes;
    }
    
    public function getCella() {
        return $this->cella;
    }

    public function setFiles($files) {
        $this->files = $files;
    }

    public function setColumnes($columnes) {
        $this->columnes = $columnes;
    }
    
    public function setCella($cella) {
        $this->cella = $cella;
    }
    
    public function afegirCella($fila, $columna) {
        $cella = new cella($fila, $columna);
        array_push($this->cella, $cella);
        return $cella;
    }

    public function mostrarTaula() {
        echo "<table border='1px'>";
        for ($compt1 = 0; $compt1 < $this->getFiles(); $compt1++) {
            echo "<tr>";
            for ($compt2 = 0; $compt2 < $this->getColumnes(); $compt2++) {
                $buida = true;
                foreach ($this->cella as $cella) {
                    if ($cella->getFiles() === $compt1+1 && $cella->getColumnes() === $compt2+1) {
                        echo "<td width='60px' height='60px' style='color: ".$cella->getColor()."; background-color: ".$cella->getFons().";'>".$cella->getInformacio()."</td>";
                        $buida = false;
                        break;
                    }
                }
                if ($buida === true) {
                    echo "<td width='60px' height='60px'></td>";
                }
            }
            echo "</tr>";
        }
        echo "</table>";
    }
            
    public function __construct($files, $columnes) {
        $this->files = $files;
        $this->columnes = $columnes;
        $this->cella = array();
    }


}