puts 'Welcome to Coffee Time!'

current_time = Time.now
current_hour_minute = current_time.strftime('%H:%M')

puts "The current time is #{current_hour_minute}"

puts "What time do you want your coffee made? Please enter in 24 hour HH:MM format"
time_to_make = gets.chomp

current_in_minutes = (current_hour_minute.split(':')[0].strip.to_i * 60) + current_hour_minute.split(':')[1].strip.to_i
make_in_minutes = (time_to_make.split(':')[0].strip.to_i * 60) + time_to_make.split(':')[1].strip.to_i

if current_in_minutes > make_in_minutes
  difference_in_minutes = 1440 - current_in_minutes + make_in_minutes
else
  difference_in_minutes = make_in_minutes - current_in_minutes
end

difference_in_hours = difference_in_minutes / 60
leftover_minutes = difference_in_minutes % 60 

puts "The time difference is #{difference_in_hours} hours and #{leftover_minutes} minutes" 

minutes_ahead = Integer(difference_in_minutes * 1.2)
difference_in_hours = minutes_ahead / 60
leftover_minutes = minutes_ahead % 60

puts "The time on the coffee maker will elapse: #{difference_in_hours} hours and #{leftover_minutes} minutes"
puts "What time is it on your coffee maker? Please enter in 24 hour HH:MM format"

time_on_maker = gets.chomp
machine_in_minutes = (time_on_maker.split(':')[0].strip.to_i * 60) + time_on_maker.split(':')[1].strip.to_i
total_minutes = machine_in_minutes + minutes_ahead

new_hours = total_minutes / 60
new_minutes = total_minutes % 60

puts "Set your coffee maker to make coffee at: #{new_hours}:#{new_minutes}"




