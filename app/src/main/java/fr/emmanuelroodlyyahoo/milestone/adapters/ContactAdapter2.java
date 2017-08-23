package fr.emmanuelroodlyyahoo.milestone.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import fr.emmanuelroodlyyahoo.milestone.Models.Contact;
import fr.emmanuelroodlyyahoo.milestone.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by Emmanuel Roodly on 19/08/2017.
 */

public class ContactAdapter2 extends ArrayAdapter<Contact> {

    public ContactAdapter2(Context context, List<Contact> contacts) {
        super(context, android.R.layout.simple_list_item_1, contacts);
    }


    public static class ViewHolder{
        TextView tvIemNom;
        TextView tvEmail;
        TextView tvTelNumber;
        TextView tvTelNumber2;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Contact aContact = getItem(position);
        ViewHolder viewHolder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_contact2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvIemNom = (TextView) convertView.findViewById(R.id.tvitemNom);

            viewHolder.tvEmail = (TextView) convertView.findViewById(R.id.tvEmail);
            viewHolder.tvTelNumber = (TextView) convertView.findViewById(R.id.tvtelNumber);
            viewHolder.tvTelNumber2 = (TextView) convertView.findViewById(R.id.tvtelNumber2);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ImageView ivImgProfil = (ImageView) convertView.findViewById(R.id.ivImgProfil);

        //Mise en place des information dans les objets view
        viewHolder.tvIemNom.setText(aContact.getNom().toString() + " " + aContact.getPrenom().toString());
        viewHolder.tvTelNumber.setText(String.valueOf(aContact.getTel()));
        viewHolder.tvEmail.setText(aContact.getEmail().toString());
        viewHolder.tvTelNumber2.setText(String.valueOf(aContact.getTel2()));

        return convertView;
    }
}