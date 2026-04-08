@extends ('store.template')
@section ('content')
<div class="container">
    <div class="page-header">
        <h1><i class="fa fa-shopping-cart"></i>Detalls del producte</h1>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="product-block">
                <img src="{{$product->image}}" width="300">
            </div>
        </div>
        <div class="col-md-6">
            <div class="product-block white-panel">
                <h3>{{$product->name}}</h3><hr>
                <div class="product-info panel">
                    <p>{{$product->description}}</p>
                    <p>Preu: {{number_format($product->price, 2)}} €</p>
                    <a class="btn btn-warning btn-block" href="{{route('cart-add', $product->slug)}}">Comprar<i class="fa fa-cart-plus fa-2x"></i></a><br>
                    <p><a class="btn btn-primary" href="{{route('home')}}"><i class ="fa fa-chevron-circle-right"></i> Tornar</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
@stop