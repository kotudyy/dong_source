package com.example.databasedoit

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.EditTextPreference
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.settings, rootKey)

            val idPref = findPreference<EditTextPreference?>("id")
            val colPref = findPreference<ListPreference?>("color")

            colPref?.summaryProvider = ListPreference.SimpleSummaryProvider.getInstance()
            idPref?.summaryProvider = Preference.SummaryProvider<EditTextPreference>{ preference ->
                val text = preference.text
                if(TextUtils.isEmpty(text)){ "설정이 되지 않았습니다"}
                else { "설정된 ID 값은 $text 입니다."}
            }
        }
    }
}