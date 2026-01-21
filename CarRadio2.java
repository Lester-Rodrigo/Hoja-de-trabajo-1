//Valeria
//Jose
public class CarRadio2 implements Radio{
    private float currentStation; 
    private boolean powerOn;
    private boolean am;
    private int[] amFavourites;
    private float[] fmFavourites;

    public CarRadio2(){
        this.am = true;
        this.currentStation = 530;
        this.powerOn = false;
        this.amFavourites = new int[12];
        this.fmFavourites = new float[12];
    }

    public void ChangeModulation(){
        if (this.powerOn){
            if (this.am){
                this.am = false;
                this.currentStation = (float)87.9;
            } else {
                this.am = true;
                this.currentStation = 530;
            }
        }
    }
    
    public void PowerOn(){
        if (this.powerOn){
            this.powerOn = false;
        } else {
            this.powerOn = true;
        }
    }

    public float getCurrentStation(){
        return this.currentStation;
    }

    public void MoveStationForward (){
        if (this.powerOn){
            if (this.am){
                int newStation = (int)this.currentStation + 10;
                if (newStation > 1610){
                    this.currentStation = 530;
                } else {
                    this.currentStation = newStation;
                }
            } else {
                float newStation = this.currentStation + (float)0.2;
                if (newStation > (float)107.9){
                    this.currentStation = (float)87.9;
                } else {
                    this.currentStation = newStation;
                }
            }
        }
    }

    public void MoveStationBackward (){
        if (this.powerOn){
            if (this.am){
                int newStation = (int)this.currentStation - 10;
                if (newStation < 530){
                    this.currentStation = 1610;
                } else {
                    this.currentStation = newStation;
                }
            } else {
                float newStation = this.currentStation - (float)0.2;
                if (newStation < 87.9){
                    this.currentStation = (float)107.9;
                } else {
                    this.currentStation = newStation;
                }
            }
        }
    }

    public void SaveToFavorite (int position){
        if (this.powerOn){
            if (this.am){
                this.amFavourites[position-1] = (int)this.currentStation; 
            } else {
                this.fmFavourites[position-1] = this.currentStation; 
            }
        }
    }

    public float GoFavorite (int position){
        if (this.powerOn){
            if (this.am){
                if (this.amFavourites[position - 1] != 0) {
                    this.currentStation = this.amFavourites[position - 1];
                    return this.currentStation;
                }
            } else {
                if (this.fmFavourites[position -1] != 0) {
                 this.currentStation = this.fmFavourites[position -1];
                 return this.currentStation;
                }
            }
        }
        return 0;
    }

    @Override
    public boolean isRadioAM() {
        return this.am;
    }

    @Override
    public boolean isRadioOn() {
        return this.powerOn;
    }
}
