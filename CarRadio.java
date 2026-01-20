public class CarRadio implements Radio {
    //Variables
    private boolean OnOff;
    private String modulation;
    private float currentStation;
    private float[] favoriteStation;

    public CarRadio() {
        this.OnOff = false;
        this.modulation = "AM";
        this.currentStation = 530f;
        this.favoriteStation = new float[13]; 
    }

    @Override
    public void PowerOn() {
        if (OnOff == false){
            OnOff = true;
        }
        else{
            OnOff = false;
        }
    }

    @Override
    public void ChangeModulation() {
        if (modulation.equals("AM")) {
            modulation = "FM";
            currentStation = 87.9f;
        } else {
            modulation = "AM";
            currentStation = 530f;
        }
        System.out.println("Se cambió a: " + modulation);
    }

    @Override
    public void MoveStationForward() {
        if (modulation.equals("AM")) {
            currentStation += 10f;
            if (currentStation > 1610f) currentStation = 530f; 
        } else {
            currentStation += 0.2f;
            if (currentStation > 107.9f) currentStation = 87.9f;
        }
        System.out.println("Estación: " + currentStation + " " + modulation);
    }

    @Override
    public void MoveStationBackward() {
       if (modulation.equals("AM")) {
            currentStation -= 10f;
            if (currentStation < 530f) currentStation = 1610f; 
        } else {
            currentStation -= 0.2f;
            if (currentStation < 87.9f) currentStation = 107.9f;
        }
        System.out.println("Estación: " + currentStation + " " + modulation);
    }

    @Override
    public void SaveToFavorite(int saveSlot) {
        if (saveSlot < 1 || saveSlot >= favoriteStation.length + 1) {
            System.out.println("Error, por favor ingrese una posición válida.");
            return;
        }
        favoriteStation[saveSlot] = currentStation;
        System.out.println("Se guardó " + currentStation + " " + modulation + " en el boton número: " + saveSlot);
    }

    @Override
    public float GoFavorite(int saveSlot) { 
        float previousStation = currentStation;
        if (saveSlot < 1 || saveSlot >= favoriteStation.length + 1) {
            System.out.println("Error, por favor ingrese una posición válida.");
        }
        currentStation = favoriteStation[saveSlot];
        if (currentStation < 530f && modulation.equals("AM")) {
            System.out.println("La estación guardada es FM y usted se encuentra en AM, cambie la modulación.");
            currentStation = previousStation;
        }
        else if (currentStation > 107.9f && modulation.equals("FM")) {
            System.out.println("La estación guardada es AM y usted se encuentra en FM, cambie la modulación.");
            currentStation = previousStation;
        }
        System.out.println("Estación actual: " + currentStation + " " + modulation);
        return currentStation;
    }

    @Override
    public float getCurrentStation(){
        return currentStation;
    }

    @Override
    public boolean isRadioAM(){
        if(modulation.equals("AM")){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isRadioOn(){
        if(OnOff == (true)){
            return true;
        }
        else{
            return false;
        }
    }
}