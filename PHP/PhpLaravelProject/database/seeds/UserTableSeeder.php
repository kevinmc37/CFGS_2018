<?php

use Illuminate\Database\Seeder;
use App\User;

class UserTableSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        //Afegint dades s'usuari
        $data= array(
            [
                'name'=>'Sergi',
                'last_name' => 'Moreno Sarrión',
                'email'=>'smsarrion@gmail.com',
                'user'=>'smsarrion',
                'password'=>\Hash::make('123$%&'),
                'type'=>'admin',
                'active'=>1,
                'adress'=>'Av Font menor. Simat de la valldigna',
                'created_at'=>new DateTime,
                'updated_at'=>new DateTime
            ],
            [
                'name'=>'Adela',
                'last_name' => 'Torres Blanc',
                'email'=>'atblanc@gmail.com',
                'user'=>'atblanc',
                'password'=>\Hash::make('123$%&'),
                'type'=>'user',
                'active'=>1,
                'adress'=>'Martí l`Humà. València',
                'created_at'=>new DateTime,
                'updated_at'=>new DateTime
            ],
            [
                'name'=>'Kevin',
                'last_name' => 'Morales Cano',
                'email'=>'blablabla@gmail.com',
                'user'=>'kevin',
                'password'=>\Hash::make('222qweee'),
                'type'=>'admin',
                'active'=>1,
                'adress'=>'Un lloc genial',
                'created_at'=>new DateTime,
                'updated_at'=>new DateTime
            ]
        );
        User::insert($data);
    }
}
