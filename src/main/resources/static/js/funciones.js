function eliminar(id){
    swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this user!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      })
      .then((ok) => {
        if (ok) {
            $.ajax({
                url:"/eliminar/"+id,
                success: function(res){
                    console.log(res);
                }
            });
          swal("Poof! User has been deleted!", {
            icon: "success",
          }).then((ok)=>{
            if(ok){
                location.href="/listar_usuarios"
            }
          });
        } else {
          swal("User data is safe!");
        }
      });
}