//Juan
//Jair
public class CarRadio3 implements Radio{
    private boolean modulation;     //AM = true, FM = false
    private boolean power;          // On = true, Off = false
    private float stationFM;        // (87.9-207.9) +- 0.2
    private int stationAM;          // (530-1610) +- 10
    private int[] favoritesAM = new int[12];
    private float[] favoritesFM = new float[12];

    public CarRadio3(){
        this.modulation = true;
        this.power = false;
        this.stationFM = (float) 87.9;
        this.stationAM = 530;
        for (int i = 0; i < 12; i++) {
            this.favoritesAM[i] = 530;
            this.favoritesFM[i] = (float) 87.9;
        }
    }
    @Override
    public void PowerOn(){
        this.power = !this.power;
    }
    @Override
    public void ChangeModulation(){
        this.modulation = !this.modulation;
    }
    @Override
    public void MoveStationForward(){
        if (this.modulation){
            if (this.stationAM == 1610){
                this.stationAM = 530;
            }
            else{
                this.stationAM += 10;
            }
        }
        else{
            if (Float.compare((float) 207.9, this.stationFM) == 0) {
                this.stationFM = (float) 87.9; 
            }
            else{
                this.stationFM += 0.2;
            }
        }
    }
    @Override
    public void MoveStationBackward(){
        if (this.modulation){
            if (this.stationAM == 530){
                this.stationAM = 1610;
            }
            else{
                this.stationAM -= 10;
            }
        }
        else{
            if (Float.compare((float) 87.9, this.stationFM) == 0) {
                this.stationFM = (float) 207.9; 
            }
            else{
                this.stationFM -= 0.2;
            }
        }
    }
    @Override
    public float GoFavorite(int position){
        if (position > 12 || position <= 0) {
            throw new IllegalArgumentException("There are only 12 favorite spots to save information.");
        }
        if (this.modulation){
            return (float) this.favoritesAM[position-1];
        }
        else{
            return this.favoritesFM[position-1];
        }
    }
    @Override
    public void SaveToFavorite(int position){
        if (position > 12 || position <= 0) {
            throw new IllegalArgumentException("There are only 12 favorite spots to save information.");
        }
        if (this.modulation){
            this.favoritesAM[position-1] = this.stationAM;
        }
        else{
            this.favoritesFM[position-1] = this.stationFM;
        }
    }
    @Override
    public boolean isRadioOn(){
        return this.power;
    }
    @Override
    public boolean isRadioAM(){
        return this.modulation;
    }
    @Override
    public float getCurrentStation(){
        if (this.modulation){
            return (float) this.stationAM;
        }
        return this.stationFM;
    }
}

