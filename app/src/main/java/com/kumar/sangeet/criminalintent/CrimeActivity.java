package com.kumar.sangeet.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class CrimeActivity extends SingleFragmentActivity {

    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}
