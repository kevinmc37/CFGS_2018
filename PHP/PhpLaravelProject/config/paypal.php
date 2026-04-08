<?php
return array(
    // set your paypal credential
    'client_id' => 'AcotFBffosUXjWkAQR1UdfQJwpQXX8-koOKxZTNsu_vVUMeg5Sw-7OMOP_3jOMdP9jVIj9mzi7jqpofM',
    'secret' => 'EKNWAeDZeyKP7l_p7N7DobIxPpHV-TSRdt5Yald-ZUslm425y1I9N853dcUWBlpJydoux5Z2GsL3JoG1',

    /**
     * SDK configuration 
     */
    'settings' => array(
        /**
         * Available option 'sandbox' or 'live'
         */
        'mode' => 'sandbox',

        /**
         * Specify the max request time in seconds
         */
        'http.ConnectionTimeOut' => 30,

        /**
         * Whether want to log to a file
         */
        'log.LogEnabled' => true,

        /**
         * Specify the file that want to write on
         */
        'log.FileName' => storage_path() . '/logs/paypal.log',

        /**
         * Available option 'FINE', 'INFO', 'WARN' or 'ERROR'
         *
         * Logging is most verbose in the 'FINE' level and decreases as you
         * proceed towards ERROR
         */
        'log.LogLevel' => 'FINE'
    ),
);