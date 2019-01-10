package com.example.ron.Players365Client.Services.JsonParser;
import com.example.ron.Players365Client.R;

/**
 * Created by Ron on 20/12/2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class JsonViewAdapter extends BaseAdapter {

    private LayoutInflater lInflater;
    private List<JsonPlayerObject> _playerList;

    public JsonViewAdapter(Context context, List<JsonPlayerObject> _playerList) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        _playerList = _playerList;
    }

    @Override

    public int getCount() {

        return _playerList.size();

    }

    @Override

    public Object getItem(int position) {

        return position;

    }

    @Override

    public long getItemId(int position) {

        return position;

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        PlayerPageViewHolder listPlayerPageViewHolder;

        if(convertView == null){

            listPlayerPageViewHolder = new PlayerPageViewHolder();

            convertView = lInflater.inflate(R.layout.player_page_view, parent, false);

            listPlayerPageViewHolder.playerName = (TextView)convertView.findViewById(R.id.player_name);

            listPlayerPageViewHolder.goals = (TextView)convertView.findViewById(R.id.goals);

            listPlayerPageViewHolder.apperences = (TextView)convertView.findViewById(R.id.appearences);

            convertView.setTag(listPlayerPageViewHolder);

        }else{

            listPlayerPageViewHolder = (PlayerPageViewHolder)convertView.getTag();

        }

        listPlayerPageViewHolder.playerName.setText("Player Name: " + _playerList.get(position).getplayerName());

        listPlayerPageViewHolder.goals.setText("Player Goals: " + _playerList.get(position).getGoals());

        listPlayerPageViewHolder.apperences.setText("Player Apperences: " + _playerList.get(position).getApperences());

        return convertView;

    }
    static class PlayerPageViewHolder{

        TextView playerName;

        TextView goals;

        TextView apperences;
    }
}
