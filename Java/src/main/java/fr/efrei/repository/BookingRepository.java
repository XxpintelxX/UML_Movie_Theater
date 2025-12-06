package fr.efrei.repository;

import fr.efrei.domain.*;
import fr.efrei.factory.*;

public interface BookingRepository {
    public void paid();
    public void cancelled();
}
