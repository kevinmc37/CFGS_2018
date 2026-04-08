<?php $__env->startSection('content'); ?>
<?php echo $__env->make('store.partials.slider', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>
<div class="container">
    <div id="products">
        <?php $__currentLoopData = $products; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $product): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
        <div class="product white-panel">
            <h3><?php echo e($product->name); ?></h3>
            <img src="<?php echo e($product->image); ?>" alt="50">
            <div class="product-info panel">
                <p><?php echo e($product->extract); ?></p>
                <h3><span class="btn btn-success">Preu: <?php echo e(number_format($product->price,2)); ?> €</span></h3>
                <p>
                    <a class="btn btn-warning" href="<?php echo e(route('cart-add', $product->slug)); ?>"><i class="fa fa-cart-plus"></i>Comprar</a>
                    <a class="btn btn-primary" href="<?php echo e(route('product-detail', $product->slug)); ?>"><i class="fa fa-chevron-circle-right"></i>Detall</a>
                </p>
            </div>
        </div>
        <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
    </div>
</div>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('store.template', array_except(get_defined_vars(), array('__data', '__path')))->render(); ?>