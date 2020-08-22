package com.example.demo.common;


public class ErrorResponseBodies {
    // data
    public static String invalid_data_history_length = "Invalid data.history_length";
    public static String invalid_data_date = "Invalid data.date";
    public static String invalid_data_symbol = "Invalid data.symbol";
    // premarket
    public static String invalid_premarket_high_price = "Invalid premarket.high.price";
    public static String invalid_premarket_high_time = "Invalid premarket.high.time";
    public static String invalid_premarket_high_significance = "Invalid premarket.high.significance";
    public static String invalid_premarket_low_after_high_price = "Invalid premarket.low_after_high.price"; // add to search
    public static String invalid_premarket_low_after_high_time = "Invalid premarket.low_after_high.time";
    public static String invalid_premarket_low_after_high_significance = "Invalid premarket.low_after_high.significance";
    // main_panic_bounce
    public static String invalid_main_panic_bounce_drop_price = "Invalid main_panic_bounce.drop.price";
    public static String invalid_main_panic_bounce_drop_time = "Invalid main_panic_bounce.drop.time";
    public static String invalid_main_panic_bounce_drop_significance = "Invalid main_panic_bounce.drop.significance";
    public static String invalid_main_panic_bounce_bottom_price = "Invalid main_panic_bounce.bottom.price";
    public static String invalid_main_panic_bounce_bottom_time = "Invalid main_panic_bounce.bottom.time";
    public static String invalid_main_panic_bounce_bottom_significance = "Invalid main_panic_bounce.bottom.significance";
    public static String invalid_main_panic_bounce_top_price = "Invalid main_panic_bounce.top.price";
    public static String invalid_main_panic_bounce_top_time = "Invalid main_panic_bounce.top.time";
    public static String invalid_main_panic_bounce_top_significance = "Invalid main_panic_bounce.top.significance";
    // technical_indicator_behaviors
    public static String invalid_technical_indicator_behaviors_price = "Invalid technical_indicator_behaviors.price";
    public static String invalid_technical_indicator_behaviors_time = "Invalid technical_indicator_behaviors.time";
    public static String invalid_technical_indicator_behaviors_type = "Invalid technical_indicator_behaviors.type";
    // key_levels
    public static String invalid_key_levels_price = "Invalid key_levels.price";
    public static String invalid_key_levels_time = "Invalid key_levels.time";
    public static String invalid_key_levels_type = "Invalid key_levels.type";
    // failed_bounces
    public static String invalid_failed_bounces_drop_price = "Invalid failed_bounces.drop.price";
    public static String invalid_failed_bounces_drop_time = "Invalid failed_bounces.drop.time";
    public static String invalid_failed_bounces_drop_significance = "Invalid failed_bounces.drop.significance";
    public static String invalid_failed_bounces_bottom_price = "Invalid failed_bounces.bottom.price";
    public static String invalid_failed_bounces_bottom_time = "Invalid failed_bounces.bottom.time";
    public static String invalid_failed_bounces_bottom_significance = "Invalid failed_bounces.bottom.significance";
    public static String invalid_failed_bounces_top_price = "Invalid failed_bounces.top.price";
    public static String invalid_failed_bounces_top_time = "Invalid failed_bounces.top.time";
    public static String invalid_failed_bounces_top_significance = "Invalid failed_bounces.top.significance";
    // pullback_bounces
    public static String invalid_pullback_bounces_drop_price = "Invalid pullback_bounces.drop.price";
    public static String invalid_pullback_bounces_drop_time = "Invalid pullback_bounces.drop.time";
    public static String invalid_pullback_bounces_drop_significance = "Invalid pullback_bounces.drop.significance";
    public static String invalid_pullback_bounces_bottom_price = "Invalid pullback_bounces.bottom.price";
    public static String invalid_pullback_bounces_bottom_time = "Invalid pullback_bounces.bottom.time";
    public static String invalid_pullback_bounces_bottom_significance = "Invalid pullback_bounces.bottom.significance";
    public static String invalid_pullback_bounces_top_price = "Invalid pullback_bounces.top.price";
    public static String invalid_pullback_bounces_top_time = "Invalid pullback_bounces.top.time";
    public static String invalid_pullback_bounces_top_significance = "Invalid pullback_bounces.top.significance";
    // failed_morning_spikes
    public static String invalid_failed_morning_spikes_start_price = "Invalid failed_morning_spikes.start.price";
    public static String invalid_failed_morning_spikes_start_time = "Invalid failed_morning_spikes.start.time";
    public static String invalid_failed_morning_spikes_start_significance = "Invalid failed_morning_spikes.start.significance";
    public static String invalid_failed_morning_spikes_top_price = "Invalid failed_morning_spikes.top.price";
    public static String invalid_failed_morning_spikes_top_time = "Invalid failed_morning_spikes.top.time";
    public static String invalid_failed_morning_spikes_top_significance = "Invalid failed_morning_spikes.top.significance";
    public static String invalid_failed_morning_spikes_bottom_price = "Invalid failed_morning_spikes.bottom.price";
    public static String invalid_failed_morning_spikes_bottom_time = "Invalid failed_morning_spikes.bottom.time";
    public static String invalid_failed_morning_spikes_bottom_significance = "Invalid failed_morning_spikes.bottom.significance";
    // catalysts
    public static String invalid_catalyst_date = "Invalid catalyst.date";
    public static String invalid_catalyst_time = "Invalid catalyst.time";
    public static String invalid_catalyst_description = "Invalid catalyst.description";


    private static String history_range = "(0 - 100)";
    private static String date_format = "(yyyy-MM-dd)";
    private static String time_format = "(HH:mm)";
    private static String positive_dollar = "($ > 0)";
    private static String significance_format = "must be a technical indicator or key level type";


    public static String get(String key){
        // data
             if(key.equals(invalid_data_history_length)){ return invalid_data_history_length +" "+history_range; }
        else if(key.equals(invalid_data_date)){ return invalid_data_date +" "+date_format; }
               else if(key.equals(invalid_data_symbol)){ return  invalid_data_symbol; }
        // premarket
        else if(key.equals(invalid_premarket_high_price)){ return invalid_premarket_high_price +" "+positive_dollar; }
        else if(key.equals(invalid_premarket_high_time)){ return invalid_premarket_high_time +" "+time_format; }
        else if(key.equals(invalid_premarket_high_significance)){ return invalid_premarket_high_significance+" "+significance_format; }
        else if(key.equals(invalid_premarket_low_after_high_price)){ return invalid_premarket_low_after_high_price +" "+positive_dollar; }
        else if(key.equals(invalid_premarket_low_after_high_time)){ return invalid_premarket_low_after_high_time +" "+time_format; }
        else if(key.equals(invalid_premarket_low_after_high_significance)){ return invalid_premarket_low_after_high_significance+" "+significance_format; }
        // main_panic_bounce
        else if(key.equals(invalid_main_panic_bounce_drop_price)){ return invalid_main_panic_bounce_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_main_panic_bounce_drop_time)){ return invalid_main_panic_bounce_drop_time+" "+time_format; }
        else if(key.equals(invalid_main_panic_bounce_drop_significance)){ return invalid_main_panic_bounce_drop_significance+" "+significance_format; }
        else if(key.equals(invalid_main_panic_bounce_bottom_price)){ return invalid_main_panic_bounce_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_main_panic_bounce_bottom_time)){ return invalid_main_panic_bounce_bottom_time+" "+time_format; }
        else if(key.equals(invalid_main_panic_bounce_bottom_significance)){ return invalid_main_panic_bounce_bottom_significance+" "+significance_format; }
        else if(key.equals(invalid_main_panic_bounce_top_price)){ return invalid_main_panic_bounce_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_main_panic_bounce_top_time)){ return invalid_main_panic_bounce_top_time+" "+time_format; }
        else if(key.equals(invalid_main_panic_bounce_top_significance)){ return invalid_main_panic_bounce_top_significance+" "+significance_format; }
        // technical_indicator_behaviors
        else if(key.equals(invalid_technical_indicator_behaviors_price)){ return invalid_technical_indicator_behaviors_price+" "+positive_dollar; }
        else if(key.equals(invalid_technical_indicator_behaviors_time)){ return invalid_technical_indicator_behaviors_time+" "+time_format; }
        else if(key.equals(invalid_technical_indicator_behaviors_type)){ return invalid_technical_indicator_behaviors_type; }
        // key_levels
        else if(key.equals(invalid_key_levels_price)){ return invalid_key_levels_price+" "+positive_dollar; }
        else if(key.equals(invalid_key_levels_type)){ return invalid_key_levels_type; }
        else if(key.equals(invalid_key_levels_time)){ return invalid_key_levels_time+" "+time_format; }
        // failed_bounces
        else if(key.equals(invalid_failed_bounces_drop_price)){ return invalid_failed_bounces_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_drop_time)){ return invalid_failed_bounces_drop_time+" "+time_format; }
        else if(key.equals(invalid_failed_bounces_drop_significance)){ return invalid_failed_bounces_drop_significance+" "+significance_format; }
        else if(key.equals(invalid_failed_bounces_bottom_price)){ return invalid_failed_bounces_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_bottom_time)){ return invalid_failed_bounces_bottom_time+" "+time_format; }
        else if(key.equals(invalid_failed_bounces_bottom_significance)){ return invalid_failed_bounces_bottom_significance+ " "+significance_format; }
        else if(key.equals(invalid_failed_bounces_top_price)){ return invalid_failed_bounces_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_bounces_top_time)){ return invalid_failed_bounces_top_time+" "+time_format; }
        else if(key.equals(invalid_failed_bounces_top_significance)){ return invalid_failed_bounces_top_significance+" "+significance_format; }
        // pullback_bounces
        else if(key.equals(invalid_pullback_bounces_drop_price)){ return invalid_pullback_bounces_drop_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_drop_time)){ return invalid_pullback_bounces_drop_time+" "+time_format; }
        else if(key.equals(invalid_pullback_bounces_drop_significance)){ return invalid_pullback_bounces_drop_significance+" "+significance_format; }
        else if(key.equals(invalid_pullback_bounces_bottom_price)){ return invalid_pullback_bounces_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_bottom_time)){ return invalid_pullback_bounces_bottom_time+" "+time_format; }
        else if(key.equals(invalid_pullback_bounces_bottom_significance)){ return invalid_pullback_bounces_bottom_significance+" "+significance_format; }
        else if(key.equals(invalid_pullback_bounces_top_price)){ return invalid_pullback_bounces_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_pullback_bounces_top_time)){ return invalid_pullback_bounces_top_time+" "+time_format; }
        else if(key.equals(invalid_pullback_bounces_top_significance)){ return invalid_pullback_bounces_top_significance+" "+significance_format; }
        // failed_morning_spikes
        else if(key.equals(invalid_failed_morning_spikes_start_price)){ return invalid_failed_morning_spikes_start_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_start_time)){ return invalid_failed_morning_spikes_start_time+" "+time_format; }
        else if(key.equals(invalid_failed_morning_spikes_start_significance)){ return invalid_failed_morning_spikes_start_significance+" "+significance_format; }
        else if(key.equals(invalid_failed_morning_spikes_top_price)){ return invalid_failed_morning_spikes_top_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_top_time)){ return invalid_failed_morning_spikes_top_time+" "+time_format; }
        else if(key.equals(invalid_failed_morning_spikes_top_significance)){ return invalid_failed_morning_spikes_top_significance+" "+significance_format; }
        else if(key.equals(invalid_failed_morning_spikes_bottom_price)){ return invalid_failed_morning_spikes_bottom_price+" "+positive_dollar; }
        else if(key.equals(invalid_failed_morning_spikes_bottom_time)){ return invalid_failed_morning_spikes_bottom_time+" "+time_format; }
        else if(key.equals(invalid_failed_morning_spikes_bottom_significance)){ return invalid_failed_morning_spikes_bottom_significance+" "+significance_format; }
        // catalyst
        else if (key.equals(invalid_catalyst_date)){ return invalid_catalyst_date+" "+date_format; }
        else if (key.equals(invalid_catalyst_time)){ return invalid_catalyst_time+" "+time_format; }
        else if (key.equals(invalid_catalyst_description)){ return invalid_catalyst_description+" (missing or too long)"; }
        else{ return "Response body key not found"; }
    }

}
