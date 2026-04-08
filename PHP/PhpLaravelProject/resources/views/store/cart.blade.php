@extends('store.template')
@section('content')
<div class="container">
    <div class="table-responsive table-cart">
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr>
                    <th>Imatge</th>
                    <th>Producte</th>
                    <th>Preu</th>
                    <th>Quantitat</th>
                    <th>Subtotal</th>
                    <th>Treure</th>
                </tr>
            </thead>
            <tbody>
                @if (count($cart))
                    <p><a href="{{route('cart-trash')}}" class="btn btn-danger">Buidar Cistella<i class="fa fa-trash"></i></a></p>
                    @foreach($cart as $item)
                        <tr>
                            <td><img src="{{$item->image}}"></td>
                            <td>{{$item->name}}</td>
                            <td>{{number_format($item->price,2)}} €</td>
                            <td>
                                <input type="number" min="1" max="100" value="{{ $item->quantity }}" id ="product_{{$item->id}}">
                                <a href="#" class="btn btn-warning btn-update-item" data-href="{{ route('cart-update', $item->slug) }}" data-id = "{{ $item->id }}"><i class="fa fa-refresh"></i></a>
                            </td>
                            <td>{{number_format($item->price * $item->quantity, 2)}} €</td>
                            <td><a href="{{route('cart-delete', $item->slug)}}" class="btn btn-danger"><i class="fa fa-remove"></i></a></td>
                        </tr>
                    @endforeach
                @else
                    <h3><span class="label label-danger">La cistella està buida</span></h3>
                @endif
                <a href="{{route('home')}}" class="btn btn-primary"><i class="fa fa-chevron-circle-left"></i>Seguir comprant</a>
                    <a href="{{route('order-detail')}}" class="btn btn-primary"><i class="fa fa-chevron-circle-right"></i>Continuar</a>
            </tbody>
        </table>
        <hr><h3><span class="btn btn-success">Total: {{number_format($total, 2)}} €</span></h3>
    </div>
</div>
@stop