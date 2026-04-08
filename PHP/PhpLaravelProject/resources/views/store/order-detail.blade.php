@extends('store.template')
@section('content')
<div class="container text-center" style="min-height: 0px;">
    <div class="page-header"><div><h1><i class="fa fa-shopping-cart"></i> Detall de la comanda </h1></div></div>
    <div class="page">
        <div class="table-responsive">
            <h1> Dades d'usuari </h1>
            <table class="table table-striped table-hover table-bordered">
                <tr><td>Nom:</td><td>{{ Auth::user()->name . " " . Auth::user()->last_name }}</td></tr>
                <tr><td>Usuari:</td><td>{{ Auth::user()->user }}</td></tr>
                <tr><td>Correu:</td><td>{{ Auth::user()->email }}</td></tr>
                <tr><td>Adreça:</td><td>{{ Auth::user()->adress }}</td></tr>
            </table>
        </div>
        <div class="table-responsive">
            <h1> Dades de la comanda </h1>
            <table class="table table-striped table-hover table-bordered">
                <tr>
                        <th>Producte</th>
                        <th>Preu</th>
                        <th>Quantitat</th>
                        <th>Subtotal</th>
                </tr>
                @foreach($cart as $item)
                <tr>
                    <td>{{$item->name}}</td>
                    <td>{{number_format($item->price,2)}}</td>
                    <td>{{$item->quantity}}</td>
                    <td>{{number_format($item->price * $item->quantity, 2)}}</td>
                </tr>
                @endforeach
            </table>
            <h3><span class="label label-success">Total: {{ number_format($total, 2) }}€</span></h3><hr>
        </div>
        <p>
            <a href="{{route('cart-show')}}" class="btn btn-primary"><i class="fa fa-chevron-circle-left"></i> Tornar</a>
            <a href="{{route('payment')}}" class="btn btn-warning">Pagar amb <i class="fa fa-cc-paypal fa-2x"></i></a>
        </p>
    </div>
</div>
@stop