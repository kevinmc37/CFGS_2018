@if (Auth::check())
    <ul class="nav navbar-nav navbar-right">
        <li><a class="fa fa-user" href="#"> {{Auth::user()->user}} <span class="caret"></span></a></li>
        <li><a href="{{route('logout')}}"><span class="glyphicon glyphicon-log-in"></span>Sortir</a></li>
    </ul>
@else
    <ul class="nav navbar-nav navbar-right">
        <li><a href="{{route('register')}}"><span class="glyphicon glyphicon-user"></span> Registrar-se </a></li>
        <li><a href="{{route('login')}}"><span class="glyphicon glyphicon-log-in"></span> Entrar </a></li>
    </ul>
@endif