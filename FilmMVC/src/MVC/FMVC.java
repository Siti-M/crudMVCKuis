package MVC;

//perintah utk menjalankan MVC, dlm hal ini MVC ada banyak macam cara.. ini salah satunya
public class FMVC {
    FView mhsview = new FView();
    FModel mhsmodel = new FModel();
    FDAO mhsDAO = new FDAO();
    FController mhscontroller = new FController(mhsmodel, mhsview, mhsDAO);
}