public interface Radio {
    void PowerOn();
    void ChangeModulation();
    void MoveStationForward ();
    void MoveStationBackward ();
    void SaveToFavorite (int position);
    float GoFavorite (int position);
    void PowerOff();


}
