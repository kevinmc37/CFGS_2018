<?php $__env->startSection('content'); ?>
<div class="container">
    <div class="page-header">
        <h1><i class="fa fa-shopping-cart"></i>Detalls del producte</h1>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="product-block">
                <img src="<?php echo e($product->image); ?>" width="300">
            </div>
        </div>
        <div class="col-md-6">
            <div class="product-block white-panel">
                <h3><?php echo e($product->name); ?></h3><hr>
                <div class="product-info panel">
                    <p><?php echo e($product->description); ?></p>
                    <p>Preu: <?php echo e(number_format($product->price, 2)); ?> €</p>
                    <a class="btn btn-warning btn-block" href="<?php echo e(route('cart-add', $product->slug)); ?>">Comprar<i class="fa fa-cart-plus fa-2x"></i></a><br>
                    <p><a class="btn btn-primary" href="<?php echo e(route('home')); ?>"><i class ="fa fa-chevron-circle-right"></i> Tornar</a></p>
                </div>
            </div>
        </div>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('store.template', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>