<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="{{route('home')}}">Botiga Laravel</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
              <ul class="nav navbar-nav">
                  <li class="active"><a href="#">Sobre nosaltres</a></li>
                  <li><a href="#">Contacte</a></li>
                  <li><a href="{{route('cart-show')}}"><i class="fa fa-cart-plus fa-2x"></i></a></li>
              </ul>
              @include ('store.partials.menu-user')
        </div>
    </div>
</nav>