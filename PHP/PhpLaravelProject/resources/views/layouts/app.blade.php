<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>@yield('title','La meva botiga Laravel')</title>
        <!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootswatch/4.0.0-beta.3/lumen/bootstrap.min.css">-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link rel="stylesheet" href="{{asset("css/main.css")}}">
    </head>
    <body>
        @include ('store.partials.nav')
        <div style="margin-top: 25px;"></div>
        @yield ('content')
        @include ('store.partials.footer')
    </body>
</html>