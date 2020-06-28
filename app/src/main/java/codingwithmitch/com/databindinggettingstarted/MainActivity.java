package codingwithmitch.com.databindinggettingstarted;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import codingwithmitch.com.databindinggettingstarted.databinding.ActivityMainBinding;
import codingwithmitch.com.databindinggettingstarted.models.Product;
import codingwithmitch.com.databindinggettingstarted.util.Products;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    //data binding
    ActivityMainBinding activityMainBinding;

    //vars
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        Products products = new Products();
        product = products.PRODUCTS[0];

        activityMainBinding.setProduct(product);
        activityMainBinding.setQuantity(1);
        activityMainBinding.setIMainActivity((IMainActivity)this);
    }


    @Override
    public void onBtnQuantity() {
        ChooseQuantityDialog dialog = new ChooseQuantityDialog();
        dialog.show(getSupportFragmentManager(), getString(R.string.dialog_choose_quantity));
    }

    @Override
    public void setQuantity(int quantity) {
        activityMainBinding.setQuantity(quantity);
    }
}
