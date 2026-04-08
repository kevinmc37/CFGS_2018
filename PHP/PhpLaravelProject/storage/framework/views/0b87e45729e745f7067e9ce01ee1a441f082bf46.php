<h1>Llistat de Productes</h1>
<?php $__currentLoopData = $products; $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $product): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
    <h3><?php echo e($product->name); ?></h3>
    <img src="<?php echo e($product->image); ?>" alt="150">
<?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>