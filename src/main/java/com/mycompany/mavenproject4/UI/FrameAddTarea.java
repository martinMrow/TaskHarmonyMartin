//<script type="text/javascript">
//		jQuery('document').ready(function($){
//
//				function verificarCamposYActualizarBoton() {
//        		let camposVacios = false;
//    
//        		// Verifica los campos de texto y email requeridos
//        		jQuery('.wpcf7 [aria-required="true"]').not('select, input[type=checkbox]').each(function() {
//            		if (jQuery(this).val().trim() === '') {
//                		camposVacios = true;
//            		}
//        		});
//    
//        		// Verifica los campos select
//        		jQuery('.wpcf7 select[aria-required="true"]').each(function() {
//            		if (jQuery(this).prop('selectedIndex') === 0 || jQuery(this).val() === null) {
//                		camposVacios = true;
//            		}
//        		});
//    
//        		// Verifica los campos checkbox con la clase 'checkCondiciones'
//        		jQuery('.wpcf7 input.checkCondiciones.required[type=checkbox]').each(function() {
//            		if (!jQuery(this).is(':checked')) {
//                		camposVacios = true;
//            		}
//        		});
//    
//        		// Activa o desactiva el botón basado en si hay campos vacíos
//        		if (camposVacios) {
//            		jQuery('.form-breaker__form .btn-submit-red').addClass('disabled');
//        		} else {
//            		jQuery('.form-breaker__form .btn-submit-red').removeClass('disabled');
//        		}
//    		}
//    
//				// Evento para campos de texto y email
//    		jQuery('.wpcf7 [aria-required="true"]').not('select, input[type=checkbox]').on('input', function() {
//        		verificarCamposYActualizarBoton();
//    		});
//    
//    		// Evento para selects y checkboxes
//    		jQuery('.wpcf7 select[aria-required="true"], .wpcf7 input.checkCondiciones[type=checkbox]').on('change', function() {
//        		verificarCamposYActualizarBoton();
//    		});
//    
//    		// Ejecuta la función al cargar la página para establecer el estado inicial
//    		jQuery(document).ready(function() {
//        		verificarCamposYActualizarBoton();
//    		});
//    
//
//				$('.asunto_select').on('change', function() {
//    				if (this.value =="Calidad"){  
//      					$(".asunto-ayuda").text("Problemas o sugerencias sobre productos y servicios..");
//     				}
//						if (this.value =='Bolsa de trabajo (Envía CV)'){ 
//                $(".asunto-ayuda").text("Envíe su CV o consulte oportunidades de empleo en nuestra empresa.");
//      					$(".div-cv").css("display", "block");
//                $(".wpcf7-form-control.wpcf7-file").addClass("wpcf7-validates-as-required");
//                $(".wpcf7-form-control.wpcf7-file").attr("aria-required","true");
//                verificarCamposYActualizarBoton();
//            } else {
//                $(".div-cv").css("display", "none");
//                $(".wpcf7-form-control.wpcf7-file").removeClass("wpcf7-validates-as-required");
//                $(".wpcf7-form-control.wpcf7-file").removeAttr("aria-required");
//                verificarCamposYActualizarBoton();
//            }
//            if (this.value =="Proveedores"){ 
//                  $(".asunto-ayuda").text("Información y soporte para proveedores actuales y potenciales.");
//                  $(".div-proveedores").css("display", "grid");
//                  $(".wpcf7-form-control.proveedores").addClass("wpcf7-validates-as-required");
//                  $(".wpcf7-form-control.proveedores").attr("aria-required","true");
//                  verificarCamposYActualizarBoton();
//            } else {
//                $(".div-proveedores").css("display", "none");
//                $(".wpcf7-form-control.proveedores").removeClass("wpcf7-validates-as-required");
//                $(".wpcf7-form-control.proveedores").removeAttr("aria-required");
//                verificarCamposYActualizarBoton();
//            }
//          	if (this.value =="Atención al cliente"){  
//      					$(".asunto-ayuda").text("Consultas generales y soporte al cliente.");
//     				}
//            if (this.value =="Otras consultas"){  
//      					$(".asunto-ayuda").text("Para cualquier otro tipo de consulta no especificada anteriormente.");
//     				}
//            if (this.value =="Seleccione una opción"){  
//      					$(".asunto-ayuda").text("");
//     				}
//          
//				});
//				
//   
//				var contactform=$('.wpcf7-form'); 
//    		contactform.append('<input type="hidden" name="asunto_final" value="" id="asunto_final">');
//
//				contactform.submit(function(event){
//						var contact_form_id = '/' + event.target[0].value;
//						event.preventDefault();
//      			contactform.clearResponse();
//						var $form = $( this );
//    
//      			var  name = $form.find( '.wpcf7-form-control-wrap.your-name input' ).val();
//      			var  email = $form.find( '.wpcf7-form-control-wrap.your-email input' ).val();
//      			var  asunto = $form.find( '#asunto' ).val();
//       			var  asunto_select  = $form.find(  'select.asunto_select '  ).val();
//      			$("#asunto_final").val(asunto_select );
//      			var acceptance = $form.find( '#privacidad' ).val();
//    
//    				console.log(" resultado: Nombre" +name + ", Mail"+email + ", Asunto "+asunto + ", Destinantario  "+asunto_select +", Aceptacion"+acceptance +", ID "+contact_form_id );
//    
//    				var is_valid = validateForm();
//  
//						if (!is_valid) {
//								//$( '.ajax-loader', $form ).removeClass( 'is-active' );
//								event.preventDefault(); 
//        
//               jQuery('.form-breaker-loading').removeClass('loading-active');
//               // jQuery('.notification').addClass('active');
//        				//errorpanel.html('Por favor rellene los datos necesarios.');
//								//errorpanel.addClass('wpcf7-validation-errors');
//								//errorpanel.css("display", "block");		
//        				return false;
//						} else {
//         			var formdata = new FormData(this);
//          			$.ajax({
//                          type: 'POST',
//                  				url: "https://vb05xl0lo1.execute-api.eu-west-1.amazonaws.com/ContactForm-PRE-NVirginia-Stage/contact-form/mawdymexico"+contact_form_id,  //PRE
//                                    // url: "https://vb05xl0lo1.execute-api.eu-west-1.amazonaws.com/ContactForm-PRE-NVirginia-Stage/contact-form/mawdypanama"+contact_form_id,  //PRO
//                 
//                                    //url: gw_params.gw_contact_url+contact_form_id,
//                          data:formdata,
//                          processData: false,
//                          contentType: false,
//                          dataType: "json",
//                          beforeSend: function(xhr) {
//                                                                        xhr.setRequestHeader('x-api-key', 'lvv6OisFOF9I5JggUwxtOaLB56SqrbOv5IEHHWk0');      //PRE
//            						//xhr.setRequestHeader('x-api-key', gw_params.gw_api_key);	
//										},	
//            //processData: false,
//           //       	contentType: false,		
//					error: function(XMLHttpRequest, textStatus, errorThrown){
//               jQuery('.form-breaker-loading').removeClass('loading-active');
//                jQuery('.notification').addClass('active');
//						//errorpanel.html('Please provide all of the required fields highlighted in red..');
//						//errorpanel.html('Impossible to connect to the server.'+errorThrown);
//						console.log(XMLHttpRequest, textStatus, errorThrown);
//						//errorpanel.addClass('wpcf7-validation-errors');
//						//errorpanel.css("display", "block");					
//					},
//            success: function(data, textStatus){ 
//					console.log (typeof data);
//					console.log(data["status"]+"   -----    ");
//					console.log("mensaje"+data["message"]);
//					console.log(data);
//  
//				switch ( data.status ) {
//							case 'validation_failed':
//            		jQuery('.form-breaker-loading').removeClass('loading-active');
//                jQuery('.notification').addClass('active');
//								/*$.each( data.invalidFields, function( i, n ) {
//									$( n.into, $form ).each( function() {
//										contactform.notValidTip( this, n.message );
//										$( '.wpcf7-form-control', this ).addClass( 'wpcf7-not-valid' );
//										$( '[aria-invalid]', this ).attr( 'aria-invalid', 'true' );
//									} );
//								} );*/
//								
//								//errorpanel.html('Uno o más campos tienen un error. Revisa los campos y vuelve a probar, por favor.');
//								//errorpanel.addClass( 'wpcf7-validation-errors' );
//								//contactform.addClass( 'invalid' );
//								//errorpanel.css("display", "block");
//								
//								break;
//							case 'acceptance_missing':
//            jQuery('.form-breaker-loading').removeClass('loading-active');
//               jQuery('.notification').addClass('active');
//								//errorpanel.html('Ha habido un error intentando enviar el mensaje. Inténtelo más tarde, por favor.');
//								//errorpanel.addClass( 'wpcf7-acceptance-missing' );
//								//contactform.addClass( 'unaccepted' );
//								//errorpanel.css("display", "block");	
//								
//								break;
//							case 'spam':
//            jQuery('.form-breaker-loading').removeClass('loading-active');
//               jQuery('.notification').addClass('active');
//								//errorpanel.html('Ha habido un error intentando enviar el mensaje. Inténtelo más tarde, por favor.');
//								//errorpanel.addClass( 'wpcf7-spam-blocked' );
//								//contactform.addClass( 'spam' );
//								//errorpanel.css("display", "block");	
//								
//								break;
//							case 'aborted':
//            jQuery('.form-breaker-loading').removeClass('loading-active');
//              jQuery('.notification').addClass('active');
//								//errorpanel.html('Ha habido un error intentando enviar el mensaje. Inténtelo más tarde, por favor.');
//								//errorpanel.addClass( 'wpcf7-aborted' );
//								//contactform.addClass( 'aborted' );
//								//errorpanel.css("display", "block");	
//
//								break;
//							case 'mail_sent':
//                $('.form-breaker').toggleClass('form-breaker--succes');
//            		$('.form-breaker .wpcf7').hide();
//            		$('.form-breaker__ok').show();
//          			jQuery('.form-breaker-loading').removeClass('loading-active');
//                  
//								contactform.trigger('reset');
//								//errorpanel.html('¡Muchas gracias! Su mensaje se ha enviado con éxito.');
//								//errorpanel.addClass( 'wpcf7-mail-sent-ok' );
//								//errorpanel.css("display", "block");
//								
//								break;
//							case 'mail_failed':
//            jQuery('.form-breaker-loading').removeClass('loading-active');
//               jQuery('.notification').addClass('active');
//								//errorpanel.html('Ha habido un error intentando enviar el mensaje. Inténtelo más tarde, por favor.');
//							//	errorpanel.addClass( 'wpcf7-mail-sent-ng' );
//								//contactform.addClass( 'failed' );
//								//errorpanel.css("display", "block");	
//																
//								break;
//							default:
//            jQuery('.form-breaker-loading').removeClass('loading-active');
//               jQuery('.notification').addClass('active');
//								//var customStatusClass = 'custom-'+ data.status.replace( /[^0-9a-z]+/i, '-' );
//								//errorpanel.html('Ha habido un error intentando enviar el mensaje. Inténtelo más tarde, por favor.');
//								//errorpanel.addClass( 'wpcf7-' + customStatusClass );
//								//contactform.addClass( customStatusClass );
//								//errorpanel.css("display", "block");
//						}
//
//
//              
//              
//						//$( '.ajax-loader', $form ).removeClass( 'is-active' );
//						//$('.wpcf7-form')[0].reset();
//          return false;    
//            }
//            //---->envio  
//
//                     
//          });
//        }
//    
//  
//  })
//  
//    //LIMPIAR CAMPOS
//    contactform.clearResponse = function( ) {			
//			contactform.removeClass( 'invalid spam sent failed' );
//			contactform.siblings( '.screen-reader-response' ).html( '' ).attr( 'role', '' );
//
//			$( '.wpcf7-not-valid-tip', contactform ).remove();
//			$( '[aria-invalid]', contactform ).attr( 'aria-invalid', 'false' );
//			$( '.wpcf7-form-control', contactform ).removeClass( 'wpcf7-not-valid' );
//
//			$( '.wpcf7-response-output', contactform )
//				.hide().empty().removeAttr( 'role' )
//				.removeClass( 'wpcf7-mail-sent-ok wpcf7-mail-sent-ng wpcf7-validation-errors wpcf7-spam-blocked' );
//		};
//    
//    
//    // VALIDACIÓN
//    
//		function validateForm() {
//      ///
//      
//          let camposVacios = false;
//        let emailInvalido = false;
//        let checkboxInvalido = false;
//      
//              // Comprobar campos con aria-required="true"
//       jQuery('.wpcf7').find('[aria-required="true"]').each(function() {
//            var inputWrapper = jQuery(this).closest('.input-wrapper');
//            // Comprobación de campos select
//            if (jQuery(this).is('select') && jQuery(this).prop('selectedIndex') === 0) {
//                selectInvalido = true;
//                jQuery(this).addClass('wpcf7-not-valid');
//                if (jQuery(this).is('select')) {
//                    jQuery(this).next('.select-styled').addClass('input-error');
//                }
//                inputWrapper.addClass('input-error');
//                if (!jQuery(this).next('.wpcf7-not-valid-tip').length) {
//                    jQuery(this).after('<span class="wpcf7-not-valid-tip">Por favor, selecciona una opción.</span>');
//                }
//            } else if (jQuery(this).val().trim() === '') {
//                // Comprobación para otros campos
//                camposVacios = true;
//                jQuery(this).addClass('wpcf7-not-valid');
//                inputWrapper.addClass('input-error');
//                if (!jQuery(this).next('.wpcf7-not-valid-tip').length) {
//                    jQuery(this).after('<span class="wpcf7-not-valid-tip">Por favor, rellena este campo.</span>');
//                }
//            } else {
//                inputWrapper.removeClass('input-error');
//                jQuery(this).removeClass('wpcf7-not-valid');
//                jQuery(this).next('.wpcf7-not-valid-tip').remove();
//                if (jQuery(this).is('select')) {
//                    jQuery(this).next('.select-styled').removeClass('input-error');
//                }
//
//                // Validación para campos de email
//                if (jQuery(this).is('[type="email"]')) {
//                    inputWrapper.addClass('input-error');
//                    const valorEmail = jQuery(this).val().trim();
//                    const regexEmail = /^[a-zA-Z0-9._-]+@([a-zA-Z0-9-]+\.)+[a-zA-Z]{2,}$/;
//                    //const regexEmail =  /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:.[a-zA-Z0-9-]+)*$/;
//                
//                    if (!regexEmail.test(valorEmail)) {
//                        emailInvalido = true;
//                        jQuery(this).addClass('wpcf7-not-valid');
//                        if (!jQuery(this).next('.wpcf7-not-valid-tip').length) {
//                            jQuery(this).after('<span class="wpcf7-not-valid-tip">Por favor, introduzca un correo válido.</span>');
//                        }
//                    } else {
//                        inputWrapper.removeClass('input-error');
//                    }
//                }                
//              
//
//                // Comprobar checkboxes
//                jQuery('.checkCondiciones.required').each(function() {
//                    if (!jQuery(this).is(':checked')) {
//                        checkboxInvalido = true;
//                        jQuery(this).closest('.consent-checkbox').addClass('checkbox-error');
//                    } else {
//                        jQuery(this).closest('.consent-checkbox').removeClass('checkbox-error');
//                    }
//                });
//            }
//        });
//      
//      
//              console.log('Campos vacios:' + camposVacios + ', ' + 'Email:' + emailInvalido  + ', '  + 'Check:' + checkboxInvalido + ', ')
//
//        // Si hay campos vacíos o errores, evita el envío y muestra los errores
//        if (camposVacios || emailInvalido  || checkboxInvalido) {
//           return false;
//        }else{
//          jQuery('.form-breaker-loading').addClass('loading-active');
//          return true;
//        }
//		}
//    
//    });
//  
//</script>