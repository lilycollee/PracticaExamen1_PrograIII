package System.logic;

import System.data.Data;
import System.data.XmlPersister;

public class Service {
    private Data data;

    public Service() {
        data = XmlPersister.instance().load();

    }
    private void guardarCambios(){
        XmlPersister.instance().store(data);
    }
}
