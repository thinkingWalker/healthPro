package com.example.hanlu.healthyadvisor.utils;

import com.example.hanlu.healthyadvisor.base.BaseListFragment;
import com.example.hanlu.healthyadvisor.fragment.BaseFragment;

import com.example.hanlu.healthyadvisor.fragment.ChildrenFragment;
import com.example.hanlu.healthyadvisor.fragment.ChildrenHeathyFragment;
import com.example.hanlu.healthyadvisor.fragment.CoupeEmotionFragment;
import com.example.hanlu.healthyadvisor.fragment.HealthyDietFragment;
import com.example.hanlu.healthyadvisor.fragment.LoseWeightFragment;
import com.example.hanlu.healthyadvisor.fragment.ManHealthyFragment;
import com.example.hanlu.healthyadvisor.fragment.MedicalNurseFragment;
import com.example.hanlu.healthyadvisor.fragment.MentalHealthyFragment;
import com.example.hanlu.healthyadvisor.fragment.NewlestFragment;
import com.example.hanlu.healthyadvisor.fragment.OldHelthFragment;
import com.example.hanlu.healthyadvisor.fragment.PregnantBabyFragment;
import com.example.hanlu.healthyadvisor.fragment.SeasonHelthyFragment;
import com.example.hanlu.healthyadvisor.fragment.SecretLifeFragment;
import com.example.hanlu.healthyadvisor.fragment.WomanKeepFragment;


/**
 * Created by hanlu on 2016/3/9.
 */
public class KnowledgeFragmentFactory {

    static BaseListFragment fragment;

    public static BaseListFragment createFragment(int position) {

        switch (position) {
            case 0:
                fragment = new NewlestFragment();

                break;
            case 1:
                fragment = new LoseWeightFragment();

//                fragment = new SecretLifeFragment();
                break;
            case 2:
                fragment = new SecretLifeFragment();
                break;
            case 3:
                fragment = new WomanKeepFragment();
            break;
            case 4:
                fragment = new ManHealthyFragment();
                break;
            case 5:
                fragment = new PregnantBabyFragment();
                break;
            case 6:

                fragment = new CoupeEmotionFragment();
                break;
            case 7:
                fragment = new ChildrenFragment();
                break;
            case 8:
                fragment = new HealthyDietFragment();
                break;
            case 9:
                fragment = new MedicalNurseFragment();
                break;
            case 10:
                fragment = new OldHelthFragment();
                break;
            case 11:
                fragment = new ChildrenHeathyFragment();
                break;
            case 12:
                fragment = new SeasonHelthyFragment();
                break;
            case 13:
                fragment = new MentalHealthyFragment();
                break;
        }


        return fragment;
    }

}
