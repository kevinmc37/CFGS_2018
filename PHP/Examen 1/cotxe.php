<?php class cotxe {
    
    private $color;
    private $portes;
    private $model;
    private $gasolina;
    
    public function plenarDeposit($gasolinanova) {
        if ($this->gasolina + $gasolinanova <= 10) { $this->setGasolina($this->gasolina + $gasolinanova); }
        else { $this->setGasolina(10); }
    }
    
    public function accelerar() {
        if ($this->gasolina - 0.1 >= 0) { $this->setGasolina($this->gasolina - 0.1); }
        else { $this->setGasolina(0); }
    }
            
    function getColor() { return $this->color; }

    function getPortes() { return $this->portes; }

    function getModel() { return $this->model; }

    function getGasolina() { return $this->gasolina; }

    function setColor($color) { $this->color = $color; }

    function setPortes($portes) { $this->portes = $portes; }

    function setModel($model) { $this->model = $model; }

    function setGasolina($gasolina) { $this->gasolina = $gasolina; }
    
    function __construct($color, $portes, $model, $gasolina) {
        $this->setColor($color);
        $this->setPortes($portes);
        $this->setModel($model);
        if ($gasolina >= 0 && $gasolina <= 10) { $this->setGasolina($gasolina); }
        elseif ($gasolina > 10) { $this->setGasolina(10); }
        else { $this->setGasolina(0); }
    }

}