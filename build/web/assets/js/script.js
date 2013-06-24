/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
!function ($) {
    $(function(){
        $(".app-section:not(.active)").hide();
        $('.input-string-group').hide();
        
        $(".nav a").on("click", function(e){
           $this = $(this);
           $this.parent().addClass('active').siblings().removeClass('active');
           
           $(".app-section.active").slideUp().removeClass('active');
           $( $this.attr('href') ).addClass('active').slideDown();
           
           e.preventDefault();
        });
        
        $('.input-toggle').click(function(){
            $this = $(this);
            
            if( $this.is(':checked') ){
                $this.parent().siblings('.input-file-group').slideUp();
                $this.parent().siblings('.input-string-group').slideDown();
            }else {
                $this.parent().siblings('.input-file-group').slideDown();
                $this.parent().siblings('.input-string-group').slideUp();
            }
            
        });
      
        $('.input-form').on('submit', function(){
            var $this = $(this)
                , $proceed = $('.input-toggle' , $this );
                
            if( ! $proceed.is(':checked') )
                return true;
                
            var $inputs = $(':input' , $this )
                , values = {};

          values['ajax']=1;
          $inputs.each(function() {
              values[this.name] = $(this).val();
          });
      
          $.ajax({
              type: "post",
              url: $this.attr('data-ajax-action'),
              data: values,
              success: function(plainData, xhrStatus, srvMsg){
                  $this.siblings('.response-box').html("<div class='message alert-success'>"+srvMsg.responseText+"</div>");
              },
              error: function(srvMsg){
                  $this.siblings('.response-box').html("<div class='message alert-error'>"+srvMsg.responseText+"</div>");
              }/*,
              complete: function(srvMsg){
                  $this.parent().append("<div class='message'>"+srvMsg.responseText+"</div>");
              }*/
          });
          return false;
      });
        
    });
}(window.jQuery);

